package com.dao;

import com.entity.ShetuanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShetuanCollectionView;

/**
 * 社团收藏 Dao 接口
 *
 * @author 
 */
public interface ShetuanCollectionDao extends BaseMapper<ShetuanCollectionEntity> {

   List<ShetuanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
