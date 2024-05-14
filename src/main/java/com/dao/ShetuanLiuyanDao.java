package com.dao;

import com.entity.ShetuanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanLiuyanView;

/**
 * 社团留言 Dao 接口
 *
 * @author 
 */
public interface ShetuanLiuyanDao extends BaseMapper<ShetuanLiuyanEntity> {

   List<ShetuanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
