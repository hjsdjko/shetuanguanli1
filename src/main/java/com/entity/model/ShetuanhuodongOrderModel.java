package com.entity.model;

import com.entity.ShetuanhuodongOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 社团活动申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShetuanhuodongOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String shetuanhuodongOrderUuidNumber;


    /**
     * 社团活动
     */
    private Integer shetuanhuodongId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 审核状态
     */
    private Integer shetuanhuodongOrderYesnoTypes;


    /**
     * 审核意见
     */
    private Integer shetuanhuodongOrderYesnoText;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getShetuanhuodongOrderUuidNumber() {
        return shetuanhuodongOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setShetuanhuodongOrderUuidNumber(String shetuanhuodongOrderUuidNumber) {
        this.shetuanhuodongOrderUuidNumber = shetuanhuodongOrderUuidNumber;
    }
    /**
	 * 获取：社团活动
	 */
    public Integer getShetuanhuodongId() {
        return shetuanhuodongId;
    }


    /**
	 * 设置：社团活动
	 */
    public void setShetuanhuodongId(Integer shetuanhuodongId) {
        this.shetuanhuodongId = shetuanhuodongId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getShetuanhuodongOrderYesnoTypes() {
        return shetuanhuodongOrderYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setShetuanhuodongOrderYesnoTypes(Integer shetuanhuodongOrderYesnoTypes) {
        this.shetuanhuodongOrderYesnoTypes = shetuanhuodongOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public Integer getShetuanhuodongOrderYesnoText() {
        return shetuanhuodongOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setShetuanhuodongOrderYesnoText(Integer shetuanhuodongOrderYesnoText) {
        this.shetuanhuodongOrderYesnoText = shetuanhuodongOrderYesnoText;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
