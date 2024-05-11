package com.dao;

import com.entity.DongqiushipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DongqiushipinVO;
import com.entity.view.DongqiushipinView;


/**
 * 懂球视频
 * 
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface DongqiushipinDao extends BaseMapper<DongqiushipinEntity> {
	
	List<DongqiushipinVO> selectListVO(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
	
	DongqiushipinVO selectVO(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
	
	List<DongqiushipinView> selectListView(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);

	List<DongqiushipinView> selectListView(Pagination page,@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
	
	DongqiushipinView selectView(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
	
}
