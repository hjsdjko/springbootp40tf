package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShangchuanshipinEntity;
import com.entity.view.ShangchuanshipinView;

import com.service.ShangchuanshipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 上传视频
 * 后端接口
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
@RestController
@RequestMapping("/shangchuanshipin")
public class ShangchuanshipinController {
    @Autowired
    private ShangchuanshipinService shangchuanshipinService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangchuanshipinEntity shangchuanshipin,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		shangchuanshipin.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shangchuanshipin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangchuanshipinEntity> ew = new EntityWrapper<ShangchuanshipinEntity>();
		PageUtils page = shangchuanshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangchuanshipin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangchuanshipinEntity shangchuanshipin, 
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shangchuanshipin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangchuanshipinEntity> ew = new EntityWrapper<ShangchuanshipinEntity>();
		PageUtils page = shangchuanshipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangchuanshipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangchuanshipinEntity shangchuanshipin){
       	EntityWrapper<ShangchuanshipinEntity> ew = new EntityWrapper<ShangchuanshipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangchuanshipin, "shangchuanshipin")); 
        return R.ok().put("data", shangchuanshipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangchuanshipinEntity shangchuanshipin){
        EntityWrapper< ShangchuanshipinEntity> ew = new EntityWrapper< ShangchuanshipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangchuanshipin, "shangchuanshipin")); 
		ShangchuanshipinView shangchuanshipinView =  shangchuanshipinService.selectView(ew);
		return R.ok("查询上传视频成功").put("data", shangchuanshipinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangchuanshipinEntity shangchuanshipin = shangchuanshipinService.selectById(id);
        return R.ok().put("data", shangchuanshipin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangchuanshipinEntity shangchuanshipin = shangchuanshipinService.selectById(id);
        return R.ok().put("data", shangchuanshipin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangchuanshipinEntity shangchuanshipin, HttpServletRequest request){
    	shangchuanshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangchuanshipin);
    	shangchuanshipin.setUserid((Long)request.getSession().getAttribute("userId"));
        shangchuanshipinService.insert(shangchuanshipin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangchuanshipinEntity shangchuanshipin, HttpServletRequest request){
    	shangchuanshipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangchuanshipin);
    	shangchuanshipin.setUserid((Long)request.getSession().getAttribute("userId"));
        shangchuanshipinService.insert(shangchuanshipin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShangchuanshipinEntity shangchuanshipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangchuanshipin);
        shangchuanshipinService.updateById(shangchuanshipin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangchuanshipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShangchuanshipinEntity> wrapper = new EntityWrapper<ShangchuanshipinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shangchuanshipinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	






}
