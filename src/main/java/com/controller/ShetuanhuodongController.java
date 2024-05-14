
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 社团活动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shetuanhuodong")
public class ShetuanhuodongController {
    private static final Logger logger = LoggerFactory.getLogger(ShetuanhuodongController.class);

    @Autowired
    private ShetuanhuodongService shetuanhuodongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShetuanService shetuanService;

    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private TuanzhangService tuanzhangService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("团长".equals(role))
            params.put("tuanzhangId",request.getSession().getAttribute("userId"));
        params.put("shetuanhuodongDeleteStart",1);params.put("shetuanhuodongDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shetuanhuodongService.queryPage(params);

        //字典表数据转换
        List<ShetuanhuodongView> list =(List<ShetuanhuodongView>)page.getList();
        for(ShetuanhuodongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShetuanhuodongEntity shetuanhuodong = shetuanhuodongService.selectById(id);
        if(shetuanhuodong !=null){
            //entity转view
            ShetuanhuodongView view = new ShetuanhuodongView();
            BeanUtils.copyProperties( shetuanhuodong , view );//把实体数据重构到view中

                //级联表
                ShetuanEntity shetuan = shetuanService.selectById(shetuanhuodong.getShetuanId());
                if(shetuan != null){
                    BeanUtils.copyProperties( shetuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShetuanId(shetuan.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shetuanhuodong:{}",this.getClass().getName(),shetuanhuodong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShetuanhuodongEntity> queryWrapper = new EntityWrapper<ShetuanhuodongEntity>()
            .eq("shetuan_id", shetuanhuodong.getShetuanId())
            .eq("shetuanhuodong_name", shetuanhuodong.getShetuanhuodongName())
            .eq("shetuanhuodong_types", shetuanhuodong.getShetuanhuodongTypes())
            .eq("shetuanhuodong_zuida", shetuanhuodong.getShetuanhuodongZuida())
            .eq("shetuanhuodong_delete", shetuanhuodong.getShetuanhuodongDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShetuanhuodongEntity shetuanhuodongEntity = shetuanhuodongService.selectOne(queryWrapper);
        if(shetuanhuodongEntity==null){
            shetuanhuodong.setShetuanhuodongDelete(1);
            shetuanhuodong.setCreateTime(new Date());
            shetuanhuodongService.insert(shetuanhuodong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shetuanhuodong:{}",this.getClass().getName(),shetuanhuodong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShetuanhuodongEntity> queryWrapper = new EntityWrapper<ShetuanhuodongEntity>()
            .notIn("id",shetuanhuodong.getId())
            .andNew()
            .eq("shetuan_id", shetuanhuodong.getShetuanId())
            .eq("shetuanhuodong_name", shetuanhuodong.getShetuanhuodongName())
            .eq("shetuanhuodong_types", shetuanhuodong.getShetuanhuodongTypes())
            .eq("shetuanhuodong_zuida", shetuanhuodong.getShetuanhuodongZuida())
            .eq("shetuanhuodong_delete", shetuanhuodong.getShetuanhuodongDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShetuanhuodongEntity shetuanhuodongEntity = shetuanhuodongService.selectOne(queryWrapper);
        if("".equals(shetuanhuodong.getShetuanhuodongPhoto()) || "null".equals(shetuanhuodong.getShetuanhuodongPhoto())){
                shetuanhuodong.setShetuanhuodongPhoto(null);
        }
        if(shetuanhuodongEntity==null){
            shetuanhuodongService.updateById(shetuanhuodong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ShetuanhuodongEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShetuanhuodongEntity shetuanhuodongEntity = new ShetuanhuodongEntity();
            shetuanhuodongEntity.setId(id);
            shetuanhuodongEntity.setShetuanhuodongDelete(2);
            list.add(shetuanhuodongEntity);
        }
        if(list != null && list.size() >0){
            shetuanhuodongService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShetuanhuodongEntity> shetuanhuodongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShetuanhuodongEntity shetuanhuodongEntity = new ShetuanhuodongEntity();
//                            shetuanhuodongEntity.setShetuanId(Integer.valueOf(data.get(0)));   //团长 要改的
//                            shetuanhuodongEntity.setShetuanhuodongName(data.get(0));                    //社团活动名称 要改的
//                            shetuanhuodongEntity.setShetuanhuodongPhoto("");//照片
//                            shetuanhuodongEntity.setShetuanhuodongTypes(Integer.valueOf(data.get(0)));   //社团活动类型 要改的
//                            shetuanhuodongEntity.setShetuanhuodongZuida(Integer.valueOf(data.get(0)));   //最大活动人数 要改的
//                            shetuanhuodongEntity.setShetuanhuodongContent("");//照片
//                            shetuanhuodongEntity.setShetuanhuodongDelete(1);//逻辑删除字段
//                            shetuanhuodongEntity.setCreateTime(date);//时间
                            shetuanhuodongList.add(shetuanhuodongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shetuanhuodongService.insertBatch(shetuanhuodongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shetuanhuodongService.queryPage(params);

        //字典表数据转换
        List<ShetuanhuodongView> list =(List<ShetuanhuodongView>)page.getList();
        for(ShetuanhuodongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShetuanhuodongEntity shetuanhuodong = shetuanhuodongService.selectById(id);
            if(shetuanhuodong !=null){


                //entity转view
                ShetuanhuodongView view = new ShetuanhuodongView();
                BeanUtils.copyProperties( shetuanhuodong , view );//把实体数据重构到view中

                //级联表
                    ShetuanEntity shetuan = shetuanService.selectById(shetuanhuodong.getShetuanId());
                if(shetuan != null){
                    BeanUtils.copyProperties( shetuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShetuanId(shetuan.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShetuanhuodongEntity shetuanhuodong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shetuanhuodong:{}",this.getClass().getName(),shetuanhuodong.toString());
        Wrapper<ShetuanhuodongEntity> queryWrapper = new EntityWrapper<ShetuanhuodongEntity>()
            .eq("shetuan_id", shetuanhuodong.getShetuanId())
            .eq("shetuanhuodong_name", shetuanhuodong.getShetuanhuodongName())
            .eq("shetuanhuodong_types", shetuanhuodong.getShetuanhuodongTypes())
            .eq("shetuanhuodong_zuida", shetuanhuodong.getShetuanhuodongZuida())
            .eq("shetuanhuodong_delete", shetuanhuodong.getShetuanhuodongDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShetuanhuodongEntity shetuanhuodongEntity = shetuanhuodongService.selectOne(queryWrapper);
        if(shetuanhuodongEntity==null){
            shetuanhuodong.setShetuanhuodongDelete(1);
            shetuanhuodong.setCreateTime(new Date());
        shetuanhuodongService.insert(shetuanhuodong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
