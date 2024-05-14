package com.entity.view;

import com.entity.ShetuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 社团
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shetuan")
public class ShetuanView extends ShetuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 社团类型的值
		*/
		private String shetuanValue;



		//级联表 tuanzhang
			/**
			* 团长姓名
			*/
			private String tuanzhangName;
			/**
			* 团长手机号
			*/
			private String tuanzhangPhone;
			/**
			* 团长身份证号
			*/
			private String tuanzhangIdNumber;
			/**
			* 团长头像
			*/
			private String tuanzhangPhoto;
			/**
			* 电子邮箱
			*/
			private String tuanzhangEmail;

	public ShetuanView() {

	}

	public ShetuanView(ShetuanEntity shetuanEntity) {
		try {
			BeanUtils.copyProperties(this, shetuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 社团类型的值
			*/
			public String getShetuanValue() {
				return shetuanValue;
			}
			/**
			* 设置： 社团类型的值
			*/
			public void setShetuanValue(String shetuanValue) {
				this.shetuanValue = shetuanValue;
			}
























				//级联表的get和set tuanzhang
					/**
					* 获取： 团长姓名
					*/
					public String getTuanzhangName() {
						return tuanzhangName;
					}
					/**
					* 设置： 团长姓名
					*/
					public void setTuanzhangName(String tuanzhangName) {
						this.tuanzhangName = tuanzhangName;
					}
					/**
					* 获取： 团长手机号
					*/
					public String getTuanzhangPhone() {
						return tuanzhangPhone;
					}
					/**
					* 设置： 团长手机号
					*/
					public void setTuanzhangPhone(String tuanzhangPhone) {
						this.tuanzhangPhone = tuanzhangPhone;
					}
					/**
					* 获取： 团长身份证号
					*/
					public String getTuanzhangIdNumber() {
						return tuanzhangIdNumber;
					}
					/**
					* 设置： 团长身份证号
					*/
					public void setTuanzhangIdNumber(String tuanzhangIdNumber) {
						this.tuanzhangIdNumber = tuanzhangIdNumber;
					}
					/**
					* 获取： 团长头像
					*/
					public String getTuanzhangPhoto() {
						return tuanzhangPhoto;
					}
					/**
					* 设置： 团长头像
					*/
					public void setTuanzhangPhoto(String tuanzhangPhoto) {
						this.tuanzhangPhoto = tuanzhangPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getTuanzhangEmail() {
						return tuanzhangEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setTuanzhangEmail(String tuanzhangEmail) {
						this.tuanzhangEmail = tuanzhangEmail;
					}




}
