package com.dao;

import com.entity.ShouzangshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShouzangshipinVO;
import com.entity.view.ShouzangshipinView;


/**
 * 收藏视频
 * 
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface ShouzangshipinDao extends BaseMapper<ShouzangshipinEntity> {
	
	List<ShouzangshipinVO> selectListVO(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
	
	ShouzangshipinVO selectVO(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
	
	List<ShouzangshipinView> selectListView(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);

	List<ShouzangshipinView> selectListView(Pagination page,@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
	
	ShouzangshipinView selectView(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
	
}
