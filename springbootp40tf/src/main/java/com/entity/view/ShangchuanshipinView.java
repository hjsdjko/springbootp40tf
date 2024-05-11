package com.entity.view;

import com.entity.ShangchuanshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 上传视频
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
@TableName("shangchuanshipin")
public class ShangchuanshipinView  extends ShangchuanshipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangchuanshipinView(){
	}
 
 	public ShangchuanshipinView(ShangchuanshipinEntity shangchuanshipinEntity){
 	try {
			BeanUtils.copyProperties(this, shangchuanshipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
