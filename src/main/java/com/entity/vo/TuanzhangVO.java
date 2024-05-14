package com.entity.vo;

import com.entity.TuanzhangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 团长
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tuanzhang")
public class TuanzhangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 团长姓名
     */

    @TableField(value = "tuanzhang_name")
    private String tuanzhangName;


    /**
     * 团长手机号
     */

    @TableField(value = "tuanzhang_phone")
    private String tuanzhangPhone;


    /**
     * 团长身份证号
     */

    @TableField(value = "tuanzhang_id_number")
    private String tuanzhangIdNumber;


    /**
     * 团长头像
     */

    @TableField(value = "tuanzhang_photo")
    private String tuanzhangPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "tuanzhang_email")
    private String tuanzhangEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：团长姓名
	 */
    public String getTuanzhangName() {
        return tuanzhangName;
    }


    /**
	 * 获取：团长姓名
	 */

    public void setTuanzhangName(String tuanzhangName) {
        this.tuanzhangName = tuanzhangName;
    }
    /**
	 * 设置：团长手机号
	 */
    public String getTuanzhangPhone() {
        return tuanzhangPhone;
    }


    /**
	 * 获取：团长手机号
	 */

    public void setTuanzhangPhone(String tuanzhangPhone) {
        this.tuanzhangPhone = tuanzhangPhone;
    }
    /**
	 * 设置：团长身份证号
	 */
    public String getTuanzhangIdNumber() {
        return tuanzhangIdNumber;
    }


    /**
	 * 获取：团长身份证号
	 */

    public void setTuanzhangIdNumber(String tuanzhangIdNumber) {
        this.tuanzhangIdNumber = tuanzhangIdNumber;
    }
    /**
	 * 设置：团长头像
	 */
    public String getTuanzhangPhoto() {
        return tuanzhangPhoto;
    }


    /**
	 * 获取：团长头像
	 */

    public void setTuanzhangPhoto(String tuanzhangPhoto) {
        this.tuanzhangPhoto = tuanzhangPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getTuanzhangEmail() {
        return tuanzhangEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setTuanzhangEmail(String tuanzhangEmail) {
        this.tuanzhangEmail = tuanzhangEmail;
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

}
