package com.entity.view;

import com.entity.ShetuanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 社团收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shetuan_collection")
public class ShetuanCollectionView extends ShetuanCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String shetuanCollectionValue;



		//级联表 shetuan
			/**
			* 社团 的 团长
			*/
			private Integer shetuanTuanzhangId;
			/**
			* 社团名称
			*/
			private String shetuanName;
			/**
			* 社团照片
			*/
			private String shetuanPhoto;
			/**
			* 社团类型
			*/
			private Integer shetuanTypes;
				/**
				* 社团类型的值
				*/
				private String shetuanValue;
			/**
			* 社团人数
			*/
			private Integer shetuanRenshu;
			/**
			* 点击次数
			*/
			private Integer shetuanClicknum;
			/**
			* 社团详情
			*/
			private String shetuanContent;
			/**
			* 逻辑删除
			*/
			private Integer shetuanDelete;

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

	public ShetuanCollectionView() {

	}

	public ShetuanCollectionView(ShetuanCollectionEntity shetuanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shetuanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getShetuanCollectionValue() {
				return shetuanCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setShetuanCollectionValue(String shetuanCollectionValue) {
				this.shetuanCollectionValue = shetuanCollectionValue;
			}







				//级联表的get和set shetuan
					/**
					* 获取：社团 的 团长
					*/
					public Integer getShetuanTuanzhangId() {
						return shetuanTuanzhangId;
					}
					/**
					* 设置：社团 的 团长
					*/
					public void setShetuanTuanzhangId(Integer shetuanTuanzhangId) {
						this.shetuanTuanzhangId = shetuanTuanzhangId;
					}

					/**
					* 获取： 社团名称
					*/
					public String getShetuanName() {
						return shetuanName;
					}
					/**
					* 设置： 社团名称
					*/
					public void setShetuanName(String shetuanName) {
						this.shetuanName = shetuanName;
					}
					/**
					* 获取： 社团照片
					*/
					public String getShetuanPhoto() {
						return shetuanPhoto;
					}
					/**
					* 设置： 社团照片
					*/
					public void setShetuanPhoto(String shetuanPhoto) {
						this.shetuanPhoto = shetuanPhoto;
					}
					/**
					* 获取： 社团类型
					*/
					public Integer getShetuanTypes() {
						return shetuanTypes;
					}
					/**
					* 设置： 社团类型
					*/
					public void setShetuanTypes(Integer shetuanTypes) {
						this.shetuanTypes = shetuanTypes;
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
					/**
					* 获取： 社团人数
					*/
					public Integer getShetuanRenshu() {
						return shetuanRenshu;
					}
					/**
					* 设置： 社团人数
					*/
					public void setShetuanRenshu(Integer shetuanRenshu) {
						this.shetuanRenshu = shetuanRenshu;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getShetuanClicknum() {
						return shetuanClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setShetuanClicknum(Integer shetuanClicknum) {
						this.shetuanClicknum = shetuanClicknum;
					}
					/**
					* 获取： 社团详情
					*/
					public String getShetuanContent() {
						return shetuanContent;
					}
					/**
					* 设置： 社团详情
					*/
					public void setShetuanContent(String shetuanContent) {
						this.shetuanContent = shetuanContent;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShetuanDelete() {
						return shetuanDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShetuanDelete(Integer shetuanDelete) {
						this.shetuanDelete = shetuanDelete;
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
