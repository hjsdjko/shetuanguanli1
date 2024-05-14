package com.entity.view;

import com.entity.ShetuanhuodongLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 社团活动留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shetuanhuodong_liuyan")
public class ShetuanhuodongLiuyanView extends ShetuanhuodongLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shetuanhuodong
			/**
			* 社团活动名称
			*/
			private String shetuanhuodongName;
			/**
			* 社团活动照片
			*/
			private String shetuanhuodongPhoto;
			/**
			* 社团活动类型
			*/
			private Integer shetuanhuodongTypes;
				/**
				* 社团活动类型的值
				*/
				private String shetuanhuodongValue;
			/**
			* 最大活动人数
			*/
			private Integer shetuanhuodongZuida;
			/**
			* 社团活动介绍
			*/
			private String shetuanhuodongContent;
			/**
			* 逻辑删除
			*/
			private Integer shetuanhuodongDelete;

		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;


	private Integer tuanzhangId;


	public ShetuanhuodongLiuyanView() {

	}

	public ShetuanhuodongLiuyanView(ShetuanhuodongLiuyanEntity shetuanhuodongLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, shetuanhuodongLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getTuanzhangId() {
		return tuanzhangId;
	}

	public void setTuanzhangId(Integer tuanzhangId) {
		this.tuanzhangId = tuanzhangId;
	}


//级联表的get和set shetuanhuodong

					/**
					* 获取： 社团活动名称
					*/
					public String getShetuanhuodongName() {
						return shetuanhuodongName;
					}
					/**
					* 设置： 社团活动名称
					*/
					public void setShetuanhuodongName(String shetuanhuodongName) {
						this.shetuanhuodongName = shetuanhuodongName;
					}
					/**
					* 获取： 社团活动照片
					*/
					public String getShetuanhuodongPhoto() {
						return shetuanhuodongPhoto;
					}
					/**
					* 设置： 社团活动照片
					*/
					public void setShetuanhuodongPhoto(String shetuanhuodongPhoto) {
						this.shetuanhuodongPhoto = shetuanhuodongPhoto;
					}
					/**
					* 获取： 社团活动类型
					*/
					public Integer getShetuanhuodongTypes() {
						return shetuanhuodongTypes;
					}
					/**
					* 设置： 社团活动类型
					*/
					public void setShetuanhuodongTypes(Integer shetuanhuodongTypes) {
						this.shetuanhuodongTypes = shetuanhuodongTypes;
					}


						/**
						* 获取： 社团活动类型的值
						*/
						public String getShetuanhuodongValue() {
							return shetuanhuodongValue;
						}
						/**
						* 设置： 社团活动类型的值
						*/
						public void setShetuanhuodongValue(String shetuanhuodongValue) {
							this.shetuanhuodongValue = shetuanhuodongValue;
						}
					/**
					* 获取： 最大活动人数
					*/
					public Integer getShetuanhuodongZuida() {
						return shetuanhuodongZuida;
					}
					/**
					* 设置： 最大活动人数
					*/
					public void setShetuanhuodongZuida(Integer shetuanhuodongZuida) {
						this.shetuanhuodongZuida = shetuanhuodongZuida;
					}
					/**
					* 获取： 社团活动介绍
					*/
					public String getShetuanhuodongContent() {
						return shetuanhuodongContent;
					}
					/**
					* 设置： 社团活动介绍
					*/
					public void setShetuanhuodongContent(String shetuanhuodongContent) {
						this.shetuanhuodongContent = shetuanhuodongContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShetuanhuodongDelete() {
						return shetuanhuodongDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShetuanhuodongDelete(Integer shetuanhuodongDelete) {
						this.shetuanhuodongDelete = shetuanhuodongDelete;
					}
















				//级联表的get和set xuesheng
					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}
					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}
					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}
					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}



}
