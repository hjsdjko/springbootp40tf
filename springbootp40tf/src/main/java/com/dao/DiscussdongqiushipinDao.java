package com.dao;

import com.entity.DiscussdongqiushipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdongqiushipinVO;
import com.entity.view.DiscussdongqiushipinView;


/**
 * 懂球视频评论表
 * 
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface DiscussdongqiushipinDao extends BaseMapper<DiscussdongqiushipinEntity> {
	
	List<DiscussdongqiushipinVO> selectListVO(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
	
	DiscussdongqiushipinVO selectVO(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
	
	List<DiscussdongqiushipinView> selectListView(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);

	List<DiscussdongqiushipinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
	
	DiscussdongqiushipinView selectView(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
	
}
