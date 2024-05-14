package com.dao;

import com.entity.ShetuanhuodongCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanhuodongCollectionView;

/**
 * 社团活动收藏 Dao 接口
 *
 * @author 
 */
public interface ShetuanhuodongCollectionDao extends BaseMapper<ShetuanhuodongCollectionEntity> {

   List<ShetuanhuodongCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
