
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
 * 团长
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tuanzhang")
public class TuanzhangController {
    private static final Logger logger = LoggerFactory.getLogger(TuanzhangController.class);

    @Autowired
    private TuanzhangService tuanzhangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private XueshengService xueshengService;


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
        PageUtils page = tuanzhangService.queryPage(params);

        //字典表数据转换
        List<TuanzhangView> list =(List<TuanzhangView>)page.getList();
        for(TuanzhangView c:list){
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
        TuanzhangEntity tuanzhang = tuanzhangService.selectById(id);
        if(tuanzhang !=null){
            //entity转view
            TuanzhangView view = new TuanzhangView();
            BeanUtils.copyProperties( tuanzhang , view );//把实体数据重构到view中

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
    public R save(@RequestBody TuanzhangEntity tuanzhang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tuanzhang:{}",this.getClass().getName(),tuanzhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TuanzhangEntity> queryWrapper = new EntityWrapper<TuanzhangEntity>()
            .eq("username", tuanzhang.getUsername())
            .or()
            .eq("tuanzhang_phone", tuanzhang.getTuanzhangPhone())
            .or()
            .eq("tuanzhang_id_number", tuanzhang.getTuanzhangIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuanzhangEntity tuanzhangEntity = tuanzhangService.selectOne(queryWrapper);
        if(tuanzhangEntity==null){
            tuanzhang.setCreateTime(new Date());
            tuanzhang.setPassword("123456");
            tuanzhangService.insert(tuanzhang);
            return R.ok();
        }else {
            return R.error(511,"账户或者团长手机号或者团长身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TuanzhangEntity tuanzhang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tuanzhang:{}",this.getClass().getName(),tuanzhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<TuanzhangEntity> queryWrapper = new EntityWrapper<TuanzhangEntity>()
            .notIn("id",tuanzhang.getId())
            .andNew()
            .eq("username", tuanzhang.getUsername())
            .or()
            .eq("tuanzhang_phone", tuanzhang.getTuanzhangPhone())
            .or()
            .eq("tuanzhang_id_number", tuanzhang.getTuanzhangIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuanzhangEntity tuanzhangEntity = tuanzhangService.selectOne(queryWrapper);
        if("".equals(tuanzhang.getTuanzhangPhoto()) || "null".equals(tuanzhang.getTuanzhangPhoto())){
                tuanzhang.setTuanzhangPhoto(null);
        }
        if(tuanzhangEntity==null){
            tuanzhangService.updateById(tuanzhang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者团长手机号或者团长身份证号已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tuanzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<TuanzhangEntity> tuanzhangList = new ArrayList<>();//上传的东西
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
                            TuanzhangEntity tuanzhangEntity = new TuanzhangEntity();
//                            tuanzhangEntity.setUsername(data.get(0));                    //账户 要改的
//                            //tuanzhangEntity.setPassword("123456");//密码
//                            tuanzhangEntity.setTuanzhangName(data.get(0));                    //团长姓名 要改的
//                            tuanzhangEntity.setTuanzhangPhone(data.get(0));                    //团长手机号 要改的
//                            tuanzhangEntity.setTuanzhangIdNumber(data.get(0));                    //团长身份证号 要改的
//                            tuanzhangEntity.setTuanzhangPhoto("");//照片
//                            tuanzhangEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            tuanzhangEntity.setTuanzhangEmail(data.get(0));                    //电子邮箱 要改的
//                            tuanzhangEntity.setCreateTime(date);//时间
                            tuanzhangList.add(tuanzhangEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //团长手机号
                                if(seachFields.containsKey("tuanzhangPhone")){
                                    List<String> tuanzhangPhone = seachFields.get("tuanzhangPhone");
                                    tuanzhangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> tuanzhangPhone = new ArrayList<>();
                                    tuanzhangPhone.add(data.get(0));//要改的
                                    seachFields.put("tuanzhangPhone",tuanzhangPhone);
                                }
                                //团长身份证号
                                if(seachFields.containsKey("tuanzhangIdNumber")){
                                    List<String> tuanzhangIdNumber = seachFields.get("tuanzhangIdNumber");
                                    tuanzhangIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tuanzhangIdNumber = new ArrayList<>();
                                    tuanzhangIdNumber.add(data.get(0));//要改的
                                    seachFields.put("tuanzhangIdNumber",tuanzhangIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<TuanzhangEntity> tuanzhangEntities_username = tuanzhangService.selectList(new EntityWrapper<TuanzhangEntity>().in("username", seachFields.get("username")));
                        if(tuanzhangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuanzhangEntity s:tuanzhangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //团长手机号
                        List<TuanzhangEntity> tuanzhangEntities_tuanzhangPhone = tuanzhangService.selectList(new EntityWrapper<TuanzhangEntity>().in("tuanzhang_phone", seachFields.get("tuanzhangPhone")));
                        if(tuanzhangEntities_tuanzhangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuanzhangEntity s:tuanzhangEntities_tuanzhangPhone){
                                repeatFields.add(s.getTuanzhangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [团长手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //团长身份证号
                        List<TuanzhangEntity> tuanzhangEntities_tuanzhangIdNumber = tuanzhangService.selectList(new EntityWrapper<TuanzhangEntity>().in("tuanzhang_id_number", seachFields.get("tuanzhangIdNumber")));
                        if(tuanzhangEntities_tuanzhangIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TuanzhangEntity s:tuanzhangEntities_tuanzhangIdNumber){
                                repeatFields.add(s.getTuanzhangIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [团长身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tuanzhangService.insertBatch(tuanzhangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        TuanzhangEntity tuanzhang = tuanzhangService.selectOne(new EntityWrapper<TuanzhangEntity>().eq("username", username));
        if(tuanzhang==null || !tuanzhang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(tuanzhang.getId(),username, "tuanzhang", "团长");
        R r = R.ok();
        r.put("token", token);
        r.put("role","团长");
        r.put("username",tuanzhang.getTuanzhangName());
        r.put("tableName","tuanzhang");
        r.put("userId",tuanzhang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody TuanzhangEntity tuanzhang){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<TuanzhangEntity> queryWrapper = new EntityWrapper<TuanzhangEntity>()
            .eq("username", tuanzhang.getUsername())
            .or()
            .eq("tuanzhang_phone", tuanzhang.getTuanzhangPhone())
            .or()
            .eq("tuanzhang_id_number", tuanzhang.getTuanzhangIdNumber())
            ;
        TuanzhangEntity tuanzhangEntity = tuanzhangService.selectOne(queryWrapper);
        if(tuanzhangEntity != null)
            return R.error("账户或者团长手机号或者团长身份证号已经被使用");
        tuanzhang.setCreateTime(new Date());
        tuanzhangService.insert(tuanzhang);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        TuanzhangEntity tuanzhang = new TuanzhangEntity();
        tuanzhang.setPassword("123456");
        tuanzhang.setId(id);
        tuanzhangService.updateById(tuanzhang);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        TuanzhangEntity tuanzhang = tuanzhangService.selectOne(new EntityWrapper<TuanzhangEntity>().eq("username", username));
        if(tuanzhang!=null){
            tuanzhang.setPassword("123456");
            boolean b = tuanzhangService.updateById(tuanzhang);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrTuanzhang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        TuanzhangEntity tuanzhang = tuanzhangService.selectById(id);
        if(tuanzhang !=null){
            //entity转view
            TuanzhangView view = new TuanzhangView();
            BeanUtils.copyProperties( tuanzhang , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = tuanzhangService.queryPage(params);

        //字典表数据转换
        List<TuanzhangView> list =(List<TuanzhangView>)page.getList();
        for(TuanzhangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TuanzhangEntity tuanzhang = tuanzhangService.selectById(id);
            if(tuanzhang !=null){


                //entity转view
                TuanzhangView view = new TuanzhangView();
                BeanUtils.copyProperties( tuanzhang , view );//把实体数据重构到view中

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
    public R add(@RequestBody TuanzhangEntity tuanzhang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tuanzhang:{}",this.getClass().getName(),tuanzhang.toString());
        Wrapper<TuanzhangEntity> queryWrapper = new EntityWrapper<TuanzhangEntity>()
            .eq("username", tuanzhang.getUsername())
            .or()
            .eq("tuanzhang_phone", tuanzhang.getTuanzhangPhone())
            .or()
            .eq("tuanzhang_id_number", tuanzhang.getTuanzhangIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TuanzhangEntity tuanzhangEntity = tuanzhangService.selectOne(queryWrapper);
        if(tuanzhangEntity==null){
            tuanzhang.setCreateTime(new Date());
        tuanzhang.setPassword("123456");
        tuanzhangService.insert(tuanzhang);
            return R.ok();
        }else {
            return R.error(511,"账户或者团长手机号或者团长身份证号已经被使用");
        }
    }


}
