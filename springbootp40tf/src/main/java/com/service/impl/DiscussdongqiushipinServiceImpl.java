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


import com.dao.DiscussdongqiushipinDao;
import com.entity.DiscussdongqiushipinEntity;
import com.service.DiscussdongqiushipinService;
import com.entity.vo.DiscussdongqiushipinVO;
import com.entity.view.DiscussdongqiushipinView;

@Service("discussdongqiushipinService")
public class DiscussdongqiushipinServiceImpl extends ServiceImpl<DiscussdongqiushipinDao, DiscussdongqiushipinEntity> implements DiscussdongqiushipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdongqiushipinEntity> page = this.selectPage(
                new Query<DiscussdongqiushipinEntity>(params).getPage(),
                new EntityWrapper<DiscussdongqiushipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdongqiushipinEntity> wrapper) {
		  Page<DiscussdongqiushipinView> page =new Query<DiscussdongqiushipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdongqiushipinVO> selectListVO(Wrapper<DiscussdongqiushipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdongqiushipinVO selectVO(Wrapper<DiscussdongqiushipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdongqiushipinView> selectListView(Wrapper<DiscussdongqiushipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdongqiushipinView selectView(Wrapper<DiscussdongqiushipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
