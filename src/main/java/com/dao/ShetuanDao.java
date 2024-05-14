package com.dao;

import com.entity.ShetuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanView;

/**
 * 社团 Dao 接口
 *
 * @author 
 */
public interface ShetuanDao extends BaseMapper<ShetuanEntity> {

   List<ShetuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
