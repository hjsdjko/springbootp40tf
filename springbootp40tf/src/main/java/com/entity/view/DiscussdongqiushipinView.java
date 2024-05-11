package com.entity.view;

import com.entity.DiscussdongqiushipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 懂球视频评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-12-13 15:11:02
 */
@TableName("discussdongqiushipin")
public class DiscussdongqiushipinView  extends DiscussdongqiushipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussdongqiushipinView(){
	}
 
 	public DiscussdongqiushipinView(DiscussdongqiushipinEntity discussdongqiushipinEntity){
 	try {
			BeanUtils.copyProperties(this, discussdongqiushipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
