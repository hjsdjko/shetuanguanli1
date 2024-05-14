package com.dao;

import com.entity.ShetuanhuodongOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanhuodongOrderView;

/**
 * 社团活动申请 Dao 接口
 *
 * @author 
 */
public interface ShetuanhuodongOrderDao extends BaseMapper<ShetuanhuodongOrderEntity> {

   List<ShetuanhuodongOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
