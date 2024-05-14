package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.ShetuanLiuyanDao;
import com.entity.ShetuanLiuyanEntity;
import com.service.ShetuanLiuyanService;
import com.entity.view.ShetuanLiuyanView;

/**
 * 社团留言 服务实现类
 */
@Service("shetuanLiuyanService")
@Transactional
public class ShetuanLiuyanServiceImpl extends ServiceImpl<ShetuanLiuyanDao, ShetuanLiuyanEntity> implements ShetuanLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShetuanLiuyanView> page =new Query<ShetuanLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
