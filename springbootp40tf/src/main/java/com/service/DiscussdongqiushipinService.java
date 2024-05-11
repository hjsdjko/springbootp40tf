package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdongqiushipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdongqiushipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdongqiushipinView;


/**
 * 懂球视频评论表
 *
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface DiscussdongqiushipinService extends IService<DiscussdongqiushipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdongqiushipinVO> selectListVO(Wrapper<DiscussdongqiushipinEntity> wrapper);
   	
   	DiscussdongqiushipinVO selectVO(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
   	
   	List<DiscussdongqiushipinView> selectListView(Wrapper<DiscussdongqiushipinEntity> wrapper);
   	
   	DiscussdongqiushipinView selectView(@Param("ew") Wrapper<DiscussdongqiushipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdongqiushipinEntity> wrapper);
   	
}

