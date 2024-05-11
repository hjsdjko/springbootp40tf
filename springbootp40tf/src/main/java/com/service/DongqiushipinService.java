package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DongqiushipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DongqiushipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DongqiushipinView;


/**
 * 懂球视频
 *
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface DongqiushipinService extends IService<DongqiushipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongqiushipinVO> selectListVO(Wrapper<DongqiushipinEntity> wrapper);
   	
   	DongqiushipinVO selectVO(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
   	
   	List<DongqiushipinView> selectListView(Wrapper<DongqiushipinEntity> wrapper);
   	
   	DongqiushipinView selectView(@Param("ew") Wrapper<DongqiushipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongqiushipinEntity> wrapper);
   	
}

