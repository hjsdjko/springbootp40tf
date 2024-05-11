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


import com.dao.ShouzangshipinDao;
import com.entity.ShouzangshipinEntity;
import com.service.ShouzangshipinService;
import com.entity.vo.ShouzangshipinVO;
import com.entity.view.ShouzangshipinView;

@Service("shouzangshipinService")
public class ShouzangshipinServiceImpl extends ServiceImpl<ShouzangshipinDao, ShouzangshipinEntity> implements ShouzangshipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShouzangshipinEntity> page = this.selectPage(
                new Query<ShouzangshipinEntity>(params).getPage(),
                new EntityWrapper<ShouzangshipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShouzangshipinEntity> wrapper) {
		  Page<ShouzangshipinView> page =new Query<ShouzangshipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShouzangshipinVO> selectListVO(Wrapper<ShouzangshipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShouzangshipinVO selectVO(Wrapper<ShouzangshipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShouzangshipinView> selectListView(Wrapper<ShouzangshipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShouzangshipinView selectView(Wrapper<ShouzangshipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
