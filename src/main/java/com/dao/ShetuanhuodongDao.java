package com.dao;

import com.entity.ShetuanhuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanhuodongView;

/**
 * 社团活动 Dao 接口
 *
 * @author 
 */
public interface ShetuanhuodongDao extends BaseMapper<ShetuanhuodongEntity> {

   List<ShetuanhuodongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
