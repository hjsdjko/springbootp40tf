package com.dao;

import com.entity.FenxiangshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FenxiangshipinVO;
import com.entity.view.FenxiangshipinView;


/**
 * 分享视频
 * 
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface FenxiangshipinDao extends BaseMapper<FenxiangshipinEntity> {
	
	List<FenxiangshipinVO> selectListVO(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
	
	FenxiangshipinVO selectVO(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
	
	List<FenxiangshipinView> selectListView(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);

	List<FenxiangshipinView> selectListView(Pagination page,@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
	
	FenxiangshipinView selectView(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
	
}
