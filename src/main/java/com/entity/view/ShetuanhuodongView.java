package com.entity.view;

import com.entity.ShetuanhuodongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 社团活动
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shetuanhuodong")
public class ShetuanhuodongView extends ShetuanhuodongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 社团活动类型的值
		*/
		private String shetuanhuodongValue;



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

	public ShetuanhuodongView() {

	}

	public ShetuanhuodongView(ShetuanhuodongEntity shetuanhuodongEntity) {
		try {
			BeanUtils.copyProperties(this, shetuanhuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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






















}
