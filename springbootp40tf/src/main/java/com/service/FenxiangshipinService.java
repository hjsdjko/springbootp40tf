package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenxiangshipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenxiangshipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenxiangshipinView;


/**
 * 分享视频
 *
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
public interface FenxiangshipinService extends IService<FenxiangshipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenxiangshipinVO> selectListVO(Wrapper<FenxiangshipinEntity> wrapper);
   	
   	FenxiangshipinVO selectVO(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
   	
   	List<FenxiangshipinView> selectListView(Wrapper<FenxiangshipinEntity> wrapper);
   	
   	FenxiangshipinView selectView(@Param("ew") Wrapper<FenxiangshipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenxiangshipinEntity> wrapper);
   	
}

