package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShouzangshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShouzangshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouzangshipinView;


/**
 * 收藏视频
 *
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface ShouzangshipinService extends IService<ShouzangshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShouzangshipinVO> selectListVO(Wrapper<ShouzangshipinEntity> wrapper);
   	
   	ShouzangshipinVO selectVO(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
   	
   	List<ShouzangshipinView> selectListView(Wrapper<ShouzangshipinEntity> wrapper);
   	
   	ShouzangshipinView selectView(@Param("ew") Wrapper<ShouzangshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShouzangshipinEntity> wrapper);
   	
}

