package com.entity.model;

import com.entity.TuanzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 团长
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TuanzhangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


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
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String tuanzhangEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：团长姓名
	 */
    public String getTuanzhangName() {
        return tuanzhangName;
    }


    /**
	 * 设置：团长姓名
	 */
    public void setTuanzhangName(String tuanzhangName) {
        this.tuanzhangName = tuanzhangName;
    }
    /**
	 * 获取：团长手机号
	 */
    public String getTuanzhangPhone() {
        return tuanzhangPhone;
    }


    /**
	 * 设置：团长手机号
	 */
    public void setTuanzhangPhone(String tuanzhangPhone) {
        this.tuanzhangPhone = tuanzhangPhone;
    }
    /**
	 * 获取：团长身份证号
	 */
    public String getTuanzhangIdNumber() {
        return tuanzhangIdNumber;
    }


    /**
	 * 设置：团长身份证号
	 */
    public void setTuanzhangIdNumber(String tuanzhangIdNumber) {
        this.tuanzhangIdNumber = tuanzhangIdNumber;
    }
    /**
	 * 获取：团长头像
	 */
    public String getTuanzhangPhoto() {
        return tuanzhangPhoto;
    }


    /**
	 * 设置：团长头像
	 */
    public void setTuanzhangPhoto(String tuanzhangPhoto) {
        this.tuanzhangPhoto = tuanzhangPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getTuanzhangEmail() {
        return tuanzhangEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setTuanzhangEmail(String tuanzhangEmail) {
        this.tuanzhangEmail = tuanzhangEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
