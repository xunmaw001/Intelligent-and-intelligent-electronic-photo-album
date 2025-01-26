package com.entity.vo;

import com.entity.XiangcexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 相册信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-01 16:54:08
 */
public class XiangcexinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 拍照地点
	 */
	
	private String paizhaodidian;
		
	/**
	 * 照片
	 */
	
	private String zhaopian;
		
	/**
	 * 相册分类
	 */
	
	private String xiangcefenlei;
		
	/**
	 * 相册名称
	 */
	
	private String xiangcemingcheng;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：拍照地点
	 */
	 
	public void setPaizhaodidian(String paizhaodidian) {
		this.paizhaodidian = paizhaodidian;
	}
	
	/**
	 * 获取：拍照地点
	 */
	public String getPaizhaodidian() {
		return paizhaodidian;
	}
				
	
	/**
	 * 设置：照片
	 */
	 
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
				
	
	/**
	 * 设置：相册分类
	 */
	 
	public void setXiangcefenlei(String xiangcefenlei) {
		this.xiangcefenlei = xiangcefenlei;
	}
	
	/**
	 * 获取：相册分类
	 */
	public String getXiangcefenlei() {
		return xiangcefenlei;
	}
				
	
	/**
	 * 设置：相册名称
	 */
	 
	public void setXiangcemingcheng(String xiangcemingcheng) {
		this.xiangcemingcheng = xiangcemingcheng;
	}
	
	/**
	 * 获取：相册名称
	 */
	public String getXiangcemingcheng() {
		return xiangcemingcheng;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
			
}
