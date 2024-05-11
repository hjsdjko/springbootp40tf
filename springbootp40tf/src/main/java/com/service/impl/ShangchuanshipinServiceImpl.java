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


import com.dao.ShangchuanshipinDao;
import com.entity.ShangchuanshipinEntity;
import com.service.ShangchuanshipinService;
import com.entity.vo.ShangchuanshipinVO;
import com.entity.view.ShangchuanshipinView;

@Service("shangchuanshipinService")
public class ShangchuanshipinServiceImpl extends ServiceImpl<ShangchuanshipinDao, ShangchuanshipinEntity> implements ShangchuanshipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangchuanshipinEntity> page = this.selectPage(
                new Query<ShangchuanshipinEntity>(params).getPage(),
                new EntityWrapper<ShangchuanshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangchuanshipinEntity> wrapper) {
		  Page<ShangchuanshipinView> page =new Query<ShangchuanshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangchuanshipinVO> selectListVO(Wrapper<ShangchuanshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangchuanshipinVO selectVO(Wrapper<ShangchuanshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangchuanshipinView> selectListView(Wrapper<ShangchuanshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangchuanshipinView selectView(Wrapper<ShangchuanshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
