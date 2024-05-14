
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
 * 社团申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shetuanOrder")
public class ShetuanOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShetuanOrderController.class);

    @Autowired
    private ShetuanOrderService shetuanOrderService;


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
    private ShetuanChengyuanService shetuanChengyuanService;



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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shetuanOrderService.queryPage(params);

        //字典表数据转换
        List<ShetuanOrderView> list =(List<ShetuanOrderView>)page.getList();
        for(ShetuanOrderView c:list){
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
        ShetuanOrderEntity shetuanOrder = shetuanOrderService.selectById(id);
        if(shetuanOrder !=null){
            //entity转view
            ShetuanOrderView view = new ShetuanOrderView();
            BeanUtils.copyProperties( shetuanOrder , view );//把实体数据重构到view中

                //级联表
                ShetuanEntity shetuan = shetuanService.selectById(shetuanOrder.getShetuanId());
                if(shetuan != null){
                    BeanUtils.copyProperties( shetuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShetuanId(shetuan.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(shetuanOrder.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody ShetuanOrderEntity shetuanOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shetuanOrder:{}",this.getClass().getName(),shetuanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            shetuanOrder.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shetuanOrder.setInsertTime(new Date());
        shetuanOrder.setCreateTime(new Date());
        shetuanOrderService.insert(shetuanOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShetuanOrderEntity shetuanOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shetuanOrder:{}",this.getClass().getName(),shetuanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            shetuanOrder.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShetuanOrderEntity> queryWrapper = new EntityWrapper<ShetuanOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShetuanOrderEntity shetuanOrderEntity = shetuanOrderService.selectOne(queryWrapper);
        if(shetuanOrderEntity==null){
            shetuanOrderService.updateById(shetuanOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShetuanOrderEntity shetuanOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shetuanOrder:{}",this.getClass().getName(),shetuanOrder.toString());

        ShetuanOrderEntity shetuanOrderEntity = shetuanOrderService.selectById(shetuanOrder.getId());

        ShetuanEntity shetuanEntity = shetuanService.selectById(shetuanOrderEntity.getShetuanId());
        if(shetuanEntity == null)
            return R.error("查不到社团");

        if(shetuanOrder.getShetuanOrderYesnoTypes() == 2){
            ShetuanChengyuanEntity shetuanChengyuanEntity = shetuanChengyuanService.selectOne(new EntityWrapper<ShetuanChengyuanEntity>().eq("shetuan_id", shetuanOrderEntity.getShetuanId()).eq("xuesheng_id", shetuanOrderEntity.getXueshengId()));
            if(shetuanChengyuanEntity != null)
                return R.error("该学生已经在该社团中,不能再次入团");

            shetuanEntity.setShetuanRenshu(shetuanEntity.getShetuanRenshu()+1);
            shetuanService.updateById(shetuanEntity);


            ShetuanChengyuanEntity shetuanChengyuanEntity1 = new ShetuanChengyuanEntity();
            shetuanChengyuanEntity1.setCreateTime(new Date());
            shetuanChengyuanEntity1.setInsertTime(new Date());
            shetuanChengyuanEntity1.setShetuanId(shetuanOrderEntity.getShetuanId());
            shetuanChengyuanEntity1.setXueshengId(shetuanOrderEntity.getXueshengId());
            shetuanChengyuanService.insert(shetuanChengyuanEntity1);
        }



        shetuanOrderEntity.setShetuanOrderYesnoTypes(shetuanOrder.getShetuanOrderYesnoTypes());
        shetuanOrderEntity.setShetuanOrderYesnoText(shetuanOrder.getShetuanOrderYesnoText());
        shetuanOrderService.updateById(shetuanOrderEntity);//根据id更新
        return R.ok();

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shetuanOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShetuanOrderEntity> shetuanOrderList = new ArrayList<>();//上传的东西
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
                            ShetuanOrderEntity shetuanOrderEntity = new ShetuanOrderEntity();
//                            shetuanOrderEntity.setShetuanOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            shetuanOrderEntity.setShetuanId(Integer.valueOf(data.get(0)));   //社团 要改的
//                            shetuanOrderEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            shetuanOrderEntity.setShetuanOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            shetuanOrderEntity.setShetuanOrderYesnoText(Integer.valueOf(data.get(0)));   //审核意见 要改的
//                            shetuanOrderEntity.setInsertTime(date);//时间
//                            shetuanOrderEntity.setCreateTime(date);//时间
                            shetuanOrderList.add(shetuanOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("shetuanOrderUuidNumber")){
                                    List<String> shetuanOrderUuidNumber = seachFields.get("shetuanOrderUuidNumber");
                                    shetuanOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shetuanOrderUuidNumber = new ArrayList<>();
                                    shetuanOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shetuanOrderUuidNumber",shetuanOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<ShetuanOrderEntity> shetuanOrderEntities_shetuanOrderUuidNumber = shetuanOrderService.selectList(new EntityWrapper<ShetuanOrderEntity>().in("shetuan_order_uuid_number", seachFields.get("shetuanOrderUuidNumber")));
                        if(shetuanOrderEntities_shetuanOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShetuanOrderEntity s:shetuanOrderEntities_shetuanOrderUuidNumber){
                                repeatFields.add(s.getShetuanOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shetuanOrderService.insertBatch(shetuanOrderList);
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
        PageUtils page = shetuanOrderService.queryPage(params);

        //字典表数据转换
        List<ShetuanOrderView> list =(List<ShetuanOrderView>)page.getList();
        for(ShetuanOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShetuanOrderEntity shetuanOrder = shetuanOrderService.selectById(id);
            if(shetuanOrder !=null){


                //entity转view
                ShetuanOrderView view = new ShetuanOrderView();
                BeanUtils.copyProperties( shetuanOrder , view );//把实体数据重构到view中

                //级联表
                    ShetuanEntity shetuan = shetuanService.selectById(shetuanOrder.getShetuanId());
                if(shetuan != null){
                    BeanUtils.copyProperties( shetuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShetuanId(shetuan.getId());
                }
                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(shetuanOrder.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R add(@RequestBody ShetuanOrderEntity shetuanOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shetuanOrder:{}",this.getClass().getName(),shetuanOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("学生".equals(role)){
            ShetuanEntity shetuanEntity = shetuanService.selectById(shetuanOrder.getShetuanId());
            if(shetuanEntity == null){
                return R.error(511,"查不到该社团");
            }


//            Integer userId = (Integer) request.getSession().getAttribute("userId");
//            shetuanOrder.setXueshengId(userId); //设置订单支付人id



//            she.selectOne(new EntityWrapper<ShetuanEntity>().eq("",""))


            ShetuanChengyuanEntity shetuanChengyuanEntity = shetuanChengyuanService.selectOne(new EntityWrapper<ShetuanChengyuanEntity>().eq("shetuan_id", shetuanOrder.getShetuanId()).eq("xuesheng_id", shetuanOrder.getXueshengId()));
            if(shetuanChengyuanEntity != null)
                return R.error("当前学生已经在该社团中了");

            List<ShetuanOrderEntity> shetuanOrderEntities = shetuanOrderService.selectList(new EntityWrapper<ShetuanOrderEntity>().eq("shetuan_id", shetuanOrder.getShetuanId()).eq("xuesheng_id", shetuanOrder.getXueshengId()));
            if(shetuanOrderEntities.size()>0)
                return R.error("当前学生已经申请过该社团了,请等待审核");



            shetuanOrder.setShetuanOrderUuidNumber(String.valueOf(new Date().getTime()));
            shetuanOrder.setInsertTime(new Date());
            shetuanOrder.setShetuanOrderYesnoTypes(1);
            shetuanOrder.setCreateTime(new Date());
            shetuanOrderService.insert(shetuanOrder);//新增订单
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }



}
