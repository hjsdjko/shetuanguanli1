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
 * 社团申请
 *
 * @author 
 * @email
 */
@TableName("shetuan_order")
public class ShetuanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShetuanOrderEntity() {

	}

	public ShetuanOrderEntity(T t) {
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
     * 订单号
     */
    @TableField(value = "shetuan_order_uuid_number")

    private String shetuanOrderUuidNumber;


    /**
     * 社团
     */
    @TableField(value = "shetuan_id")

    private Integer shetuanId;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 审核状态
     */
    @TableField(value = "shetuan_order_yesno_types")

    private Integer shetuanOrderYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "shetuan_order_yesno_text")

    private String shetuanOrderYesnoText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：订单号
	 */
    public String getShetuanOrderUuidNumber() {
        return shetuanOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setShetuanOrderUuidNumber(String shetuanOrderUuidNumber) {
        this.shetuanOrderUuidNumber = shetuanOrderUuidNumber;
    }
    /**
	 * 设置：社团
	 */
    public Integer getShetuanId() {
        return shetuanId;
    }


    /**
	 * 获取：社团
	 */

    public void setShetuanId(Integer shetuanId) {
        this.shetuanId = shetuanId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getShetuanOrderYesnoTypes() {
        return shetuanOrderYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setShetuanOrderYesnoTypes(Integer shetuanOrderYesnoTypes) {
        this.shetuanOrderYesnoTypes = shetuanOrderYesnoTypes;
    }

    public String getShetuanOrderYesnoText() {
        return shetuanOrderYesnoText;
    }

    public void setShetuanOrderYesnoText(String shetuanOrderYesnoText) {
        this.shetuanOrderYesnoText = shetuanOrderYesnoText;
    }

    /**
	 * 设置：预约时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "ShetuanOrder{" +
            "id=" + id +
            ", shetuanOrderUuidNumber=" + shetuanOrderUuidNumber +
            ", shetuanId=" + shetuanId +
            ", xueshengId=" + xueshengId +
            ", shetuanOrderYesnoTypes=" + shetuanOrderYesnoTypes +
            ", shetuanOrderYesnoText=" + shetuanOrderYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
