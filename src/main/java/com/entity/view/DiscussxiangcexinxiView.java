package com.entity.view;

import com.entity.DiscussxiangcexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 相册信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-01 16:54:08
 */
@TableName("discussxiangcexinxi")
public class DiscussxiangcexinxiView  extends DiscussxiangcexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxiangcexinxiView(){
	}
 
 	public DiscussxiangcexinxiView(DiscussxiangcexinxiEntity discussxiangcexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussxiangcexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
