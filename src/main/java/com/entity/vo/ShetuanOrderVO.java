package com.entity.vo;

import com.entity.ShetuanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社团申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shetuan_order")
public class ShetuanOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
    private Integer shetuanOrderYesnoText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
    /**
	 * 设置：审核意见
	 */
    public Integer getShetuanOrderYesnoText() {
        return shetuanOrderYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setShetuanOrderYesnoText(Integer shetuanOrderYesnoText) {
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
