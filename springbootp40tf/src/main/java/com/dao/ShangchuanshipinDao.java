package com.dao;

import com.entity.ShangchuanshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangchuanshipinVO;
import com.entity.view.ShangchuanshipinView;


/**
 * 上传视频
 * 
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface ShangchuanshipinDao extends BaseMapper<ShangchuanshipinEntity> {
	
	List<ShangchuanshipinVO> selectListVO(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
	
	ShangchuanshipinVO selectVO(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
	
	List<ShangchuanshipinView> selectListView(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);

	List<ShangchuanshipinView> selectListView(Pagination page,@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
	
	ShangchuanshipinView selectView(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
	
}
