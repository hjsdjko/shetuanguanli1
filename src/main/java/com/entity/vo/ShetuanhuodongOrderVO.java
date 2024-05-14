package com.entity.vo;

import com.entity.ShetuanhuodongOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社团活动申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shetuanhuodong_order")
public class ShetuanhuodongOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "shetuanhuodong_order_uuid_number")
    private String shetuanhuodongOrderUuidNumber;


    /**
     * 社团活动
     */

    @TableField(value = "shetuanhuodong_id")
    private Integer shetuanhuodongId;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 审核状态
     */

    @TableField(value = "shetuanhuodong_order_yesno_types")
    private Integer shetuanhuodongOrderYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "shetuanhuodong_order_yesno_text")
    private Integer shetuanhuodongOrderYesnoText;


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
    public String getShetuanhuodongOrderUuidNumber() {
        return shetuanhuodongOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setShetuanhuodongOrderUuidNumber(String shetuanhuodongOrderUuidNumber) {
        this.shetuanhuodongOrderUuidNumber = shetuanhuodongOrderUuidNumber;
    }
    /**
	 * 设置：社团活动
	 */
    public Integer getShetuanhuodongId() {
        return shetuanhuodongId;
    }


    /**
	 * 获取：社团活动
	 */

    public void setShetuanhuodongId(Integer shetuanhuodongId) {
        this.shetuanhuodongId = shetuanhuodongId;
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
    public Integer getShetuanhuodongOrderYesnoTypes() {
        return shetuanhuodongOrderYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setShetuanhuodongOrderYesnoTypes(Integer shetuanhuodongOrderYesnoTypes) {
        this.shetuanhuodongOrderYesnoTypes = shetuanhuodongOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public Integer getShetuanhuodongOrderYesnoText() {
        return shetuanhuodongOrderYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setShetuanhuodongOrderYesnoText(Integer shetuanhuodongOrderYesnoText) {
        this.shetuanhuodongOrderYesnoText = shetuanhuodongOrderYesnoText;
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
