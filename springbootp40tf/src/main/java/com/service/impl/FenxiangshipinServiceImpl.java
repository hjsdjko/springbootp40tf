package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FenxiangshipinDao;
import com.entity.FenxiangshipinEntity;
import com.service.FenxiangshipinService;
import com.entity.vo.FenxiangshipinVO;
import com.entity.view.FenxiangshipinView;

@Service("fenxiangshipinService")
public class FenxiangshipinServiceImpl extends ServiceImpl<FenxiangshipinDao, FenxiangshipinEntity> implements FenxiangshipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenxiangshipinEntity> page = this.selectPage(
                new Query<FenxiangshipinEntity>(params).getPage(),
                new EntityWrapper<FenxiangshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenxiangshipinEntity> wrapper) {
		  Page<FenxiangshipinView> page =new Query<FenxiangshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FenxiangshipinVO> selectListVO(Wrapper<FenxiangshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FenxiangshipinVO selectVO(Wrapper<FenxiangshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FenxiangshipinView> selectListView(Wrapper<FenxiangshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenxiangshipinView selectView(Wrapper<FenxiangshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
