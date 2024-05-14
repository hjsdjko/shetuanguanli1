package com.entity.model;

import com.entity.ShetuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 社团
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShetuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 团长
     */
    private Integer tuanzhangId;


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


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：团长
	 */
    public Integer getTuanzhangId() {
        return tuanzhangId;
    }


    /**
	 * 设置：团长
	 */
    public void setTuanzhangId(Integer tuanzhangId) {
        this.tuanzhangId = tuanzhangId;
    }
    /**
	 * 获取：社团名称
	 */
    public String getShetuanName() {
        return shetuanName;
    }


    /**
	 * 设置：社团名称
	 */
    public void setShetuanName(String shetuanName) {
        this.shetuanName = shetuanName;
    }
    /**
	 * 获取：社团照片
	 */
    public String getShetuanPhoto() {
        return shetuanPhoto;
    }


    /**
	 * 设置：社团照片
	 */
    public void setShetuanPhoto(String shetuanPhoto) {
        this.shetuanPhoto = shetuanPhoto;
    }
    /**
	 * 获取：社团类型
	 */
    public Integer getShetuanTypes() {
        return shetuanTypes;
    }


    /**
	 * 设置：社团类型
	 */
    public void setShetuanTypes(Integer shetuanTypes) {
        this.shetuanTypes = shetuanTypes;
    }
    /**
	 * 获取：社团人数
	 */
    public Integer getShetuanRenshu() {
        return shetuanRenshu;
    }


    /**
	 * 设置：社团人数
	 */
    public void setShetuanRenshu(Integer shetuanRenshu) {
        this.shetuanRenshu = shetuanRenshu;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getShetuanClicknum() {
        return shetuanClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setShetuanClicknum(Integer shetuanClicknum) {
        this.shetuanClicknum = shetuanClicknum;
    }
    /**
	 * 获取：社团详情
	 */
    public String getShetuanContent() {
        return shetuanContent;
    }


    /**
	 * 设置：社团详情
	 */
    public void setShetuanContent(String shetuanContent) {
        this.shetuanContent = shetuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShetuanDelete() {
        return shetuanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShetuanDelete(Integer shetuanDelete) {
        this.shetuanDelete = shetuanDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
