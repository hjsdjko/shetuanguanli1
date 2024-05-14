package com.entity.view;

import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 论坛
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 帖子状态的值
		*/
		private String forumStateValue;



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

		//级联表 users
			/**
			* 用户名
			*/
			private String uusername;
			/**
			* 密码
			*/
			private String upassword;
			/**
			* 角色
			*/
			private String urole;
			/**
			* 新增时间
			*/
			private Date uaddtime;

	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 帖子状态的值
			*/
			public String getForumStateValue() {
				return forumStateValue;
			}
			/**
			* 设置： 帖子状态的值
			*/
			public void setForumStateValue(String forumStateValue) {
				this.forumStateValue = forumStateValue;
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






			//级联表的get和set users
					/**
					* 获取： 用户名
					*/
					public String getUusername() {
						return uusername;
					}
					/**
					* 设置： 用户名
					*/
					public void setUusername(String uusername) {
						this.uusername = uusername;
					}
					/**
					* 获取： 密码
					*/
					public String getUpassword() {
						return upassword;
					}
					/**
					* 设置： 密码
					*/
					public void setUpassword(String upassword) {
						this.upassword = upassword;
					}
					/**
					* 获取： 角色
					*/
					public String getUrole() {
						return urole;
					}
					/**
					* 设置： 角色
					*/
					public void setUrole(String urole) {
						this.urole = urole;
					}
					/**
					* 获取： 新增时间
					*/
					public Date getUaddtime() {
						return uaddtime;
					}
					/**
					* 设置： 新增时间
					*/
					public void setUaddtime(Date uaddtime) {
						this.uaddtime = uaddtime;
					}
}
