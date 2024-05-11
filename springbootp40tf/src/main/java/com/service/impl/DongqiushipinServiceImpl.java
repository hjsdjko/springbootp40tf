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


import com.dao.DongqiushipinDao;
import com.entity.DongqiushipinEntity;
import com.service.DongqiushipinService;
import com.entity.vo.DongqiushipinVO;
import com.entity.view.DongqiushipinView;

@Service("dongqiushipinService")
public class DongqiushipinServiceImpl extends ServiceImpl<DongqiushipinDao, DongqiushipinEntity> implements DongqiushipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongqiushipinEntity> page = this.selectPage(
                new Query<DongqiushipinEntity>(params).getPage(),
                new EntityWrapper<DongqiushipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongqiushipinEntity> wrapper) {
		  Page<DongqiushipinView> page =new Query<DongqiushipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DongqiushipinVO> selectListVO(Wrapper<DongqiushipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DongqiushipinVO selectVO(Wrapper<DongqiushipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DongqiushipinView> selectListView(Wrapper<DongqiushipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongqiushipinView selectView(Wrapper<DongqiushipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
