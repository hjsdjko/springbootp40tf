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

import com.entity.DongqiushipinEntity;
import com.entity.view.DongqiushipinView;

import com.service.DongqiushipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 懂球视频
 * 后端接口
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
@RestController
@RequestMapping("/dongqiushipin")
public class DongqiushipinController {
    @Autowired
    private DongqiushipinService dongqiushipinService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongqiushipinEntity dongqiushipin,
		HttpServletRequest request){
        EntityWrapper<DongqiushipinEntity> ew = new EntityWrapper<DongqiushipinEntity>();
		PageUtils page = dongqiushipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongqiushipin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongqiushipinEntity dongqiushipin, 
		HttpServletRequest request){
        EntityWrapper<DongqiushipinEntity> ew = new EntityWrapper<DongqiushipinEntity>();
		PageUtils page = dongqiushipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongqiushipin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongqiushipinEntity dongqiushipin){
       	EntityWrapper<DongqiushipinEntity> ew = new EntityWrapper<DongqiushipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongqiushipin, "dongqiushipin")); 
        return R.ok().put("data", dongqiushipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongqiushipinEntity dongqiushipin){
        EntityWrapper< DongqiushipinEntity> ew = new EntityWrapper< DongqiushipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongqiushipin, "dongqiushipin")); 
		DongqiushipinView dongqiushipinView =  dongqiushipinService.selectView(ew);
		return R.ok("查询懂球视频成功").put("data", dongqiushipinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongqiushipinEntity dongqiushipin = dongqiushipinService.selectById(id);
		dongqiushipin.setClicknum(dongqiushipin.getClicknum()+1);
		dongqiushipin.setClicktime(new Date());
		dongqiushipinService.updateById(dongqiushipin);
        return R.ok().put("data", dongqiushipin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongqiushipinEntity dongqiushipin = dongqiushipinService.selectById(id);
		dongqiushipin.setClicknum(dongqiushipin.getClicknum()+1);
		dongqiushipin.setClicktime(new Date());
		dongqiushipinService.updateById(dongqiushipin);
        return R.ok().put("data", dongqiushipin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        DongqiushipinEntity dongqiushipin = dongqiushipinService.selectById(id);
        if(type.equals("1")) {
        	dongqiushipin.setThumbsupnum(dongqiushipin.getThumbsupnum()+1);
        } else {
        	dongqiushipin.setCrazilynum(dongqiushipin.getCrazilynum()+1);
        }
        dongqiushipinService.updateById(dongqiushipin);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongqiushipinEntity dongqiushipin, HttpServletRequest request){
    	dongqiushipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongqiushipin);
        dongqiushipinService.insert(dongqiushipin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongqiushipinEntity dongqiushipin, HttpServletRequest request){
    	dongqiushipin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongqiushipin);
        dongqiushipinService.insert(dongqiushipin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DongqiushipinEntity dongqiushipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongqiushipin);
        dongqiushipinService.updateById(dongqiushipin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongqiushipinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DongqiushipinEntity> wrapper = new EntityWrapper<DongqiushipinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = dongqiushipinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DongqiushipinEntity dongqiushipin, HttpServletRequest request,String pre){
        EntityWrapper<DongqiushipinEntity> ew = new EntityWrapper<DongqiushipinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = dongqiushipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongqiushipin), params), params));
        return R.ok().put("data", page);
    }






}
