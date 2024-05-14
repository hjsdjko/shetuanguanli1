package com.dao;

import com.entity.TuanzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TuanzhangView;

/**
 * 团长 Dao 接口
 *
 * @author 
 */
public interface TuanzhangDao extends BaseMapper<TuanzhangEntity> {

   List<TuanzhangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
