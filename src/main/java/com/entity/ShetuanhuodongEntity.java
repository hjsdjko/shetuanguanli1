package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 社团活动
 *
 * @author 
 * @email
 */
@TableName("shetuanhuodong")
public class ShetuanhuodongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShetuanhuodongEntity() {

	}

	public ShetuanhuodongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 团长
     */
    @TableField(value = "shetuan_id")

    private Integer shetuanId;


    /**
     * 社团活动名称
     */
    @TableField(value = "shetuanhuodong_name")

    private String shetuanhuodongName;


    /**
     * 社团活动照片
     */
    @TableField(value = "shetuanhuodong_photo")

    private String shetuanhuodongPhoto;


    /**
     * 社团活动类型
     */
    @TableField(value = "shetuanhuodong_types")

    private Integer shetuanhuodongTypes;


    /**
     * 最大活动人数
     */
    @TableField(value = "shetuanhuodong_zuida")

    private Integer shetuanhuodongZuida;


    /**
     * 社团活动介绍
     */
    @TableField(value = "shetuanhuodong_content")

    private String shetuanhuodongContent;


    /**
     * 逻辑删除
     */
    @TableField(value = "shetuanhuodong_delete")

    private Integer shetuanhuodongDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：团长
	 */
    public Integer getShetuanId() {
        return shetuanId;
    }


    /**
	 * 获取：团长
	 */

    public void setShetuanId(Integer shetuanId) {
        this.shetuanId = shetuanId;
    }
    /**
	 * 设置：社团活动名称
	 */
    public String getShetuanhuodongName() {
        return shetuanhuodongName;
    }


    /**
	 * 获取：社团活动名称
	 */

    public void setShetuanhuodongName(String shetuanhuodongName) {
        this.shetuanhuodongName = shetuanhuodongName;
    }
    /**
	 * 设置：社团活动照片
	 */
    public String getShetuanhuodongPhoto() {
        return shetuanhuodongPhoto;
    }


    /**
	 * 获取：社团活动照片
	 */

    public void setShetuanhuodongPhoto(String shetuanhuodongPhoto) {
        this.shetuanhuodongPhoto = shetuanhuodongPhoto;
    }
    /**
	 * 设置：社团活动类型
	 */
    public Integer getShetuanhuodongTypes() {
        return shetuanhuodongTypes;
    }


    /**
	 * 获取：社团活动类型
	 */

    public void setShetuanhuodongTypes(Integer shetuanhuodongTypes) {
        this.shetuanhuodongTypes = shetuanhuodongTypes;
    }
    /**
	 * 设置：最大活动人数
	 */
    public Integer getShetuanhuodongZuida() {
        return shetuanhuodongZuida;
    }


    /**
	 * 获取：最大活动人数
	 */

    public void setShetuanhuodongZuida(Integer shetuanhuodongZuida) {
        this.shetuanhuodongZuida = shetuanhuodongZuida;
    }
    /**
	 * 设置：社团活动介绍
	 */
    public String getShetuanhuodongContent() {
        return shetuanhuodongContent;
    }


    /**
	 * 获取：社团活动介绍
	 */

    public void setShetuanhuodongContent(String shetuanhuodongContent) {
        this.shetuanhuodongContent = shetuanhuodongContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShetuanhuodongDelete() {
        return shetuanhuodongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShetuanhuodongDelete(Integer shetuanhuodongDelete) {
        this.shetuanhuodongDelete = shetuanhuodongDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shetuanhuodong{" +
            "id=" + id +
            ", shetuanId=" + shetuanId +
            ", shetuanhuodongName=" + shetuanhuodongName +
            ", shetuanhuodongPhoto=" + shetuanhuodongPhoto +
            ", shetuanhuodongTypes=" + shetuanhuodongTypes +
            ", shetuanhuodongZuida=" + shetuanhuodongZuida +
            ", shetuanhuodongContent=" + shetuanhuodongContent +
            ", shetuanhuodongDelete=" + shetuanhuodongDelete +
            ", createTime=" + createTime +
        "}";
    }
}
