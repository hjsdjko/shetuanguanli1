package com.dao;

import com.entity.ShetuanhuodongLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanhuodongLiuyanView;

/**
 * 社团活动留言 Dao 接口
 *
 * @author 
 */
public interface ShetuanhuodongLiuyanDao extends BaseMapper<ShetuanhuodongLiuyanEntity> {

   List<ShetuanhuodongLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
