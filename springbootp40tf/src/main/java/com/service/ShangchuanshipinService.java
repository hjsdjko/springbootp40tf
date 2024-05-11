package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangchuanshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangchuanshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangchuanshipinView;


/**
 * 上传视频
 *
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface ShangchuanshipinService extends IService<ShangchuanshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangchuanshipinVO> selectListVO(Wrapper<ShangchuanshipinEntity> wrapper);
   	
   	ShangchuanshipinVO selectVO(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
   	
   	List<ShangchuanshipinView> selectListView(Wrapper<ShangchuanshipinEntity> wrapper);
   	
   	ShangchuanshipinView selectView(@Param("ew") Wrapper<ShangchuanshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangchuanshipinEntity> wrapper);
   	
}

