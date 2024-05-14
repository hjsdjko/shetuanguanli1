package com.entity.model;

import com.entity.ShetuanhuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 社团活动
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShetuanhuodongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 团长
     */
    private Integer shetuanId;


    /**
     * 社团活动名称
     */
    private String shetuanhuodongName;


    /**
     * 社团活动照片
     */
    private String shetuanhuodongPhoto;


    /**
     * 社团活动类型
     */
    private Integer shetuanhuodongTypes;


    /**
     * 最大活动人数
     */
    private Integer shetuanhuodongZuida;


    /**
     * 社团活动介绍
     */
    private String shetuanhuodongContent;


    /**
     * 逻辑删除
     */
    private Integer shetuanhuodongDelete;


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
    public Integer getShetuanId() {
        return shetuanId;
    }


    /**
	 * 设置：团长
	 */
    public void setShetuanId(Integer shetuanId) {
        this.shetuanId = shetuanId;
    }
    /**
	 * 获取：社团活动名称
	 */
    public String getShetuanhuodongName() {
        return shetuanhuodongName;
    }


    /**
	 * 设置：社团活动名称
	 */
    public void setShetuanhuodongName(String shetuanhuodongName) {
        this.shetuanhuodongName = shetuanhuodongName;
    }
    /**
	 * 获取：社团活动照片
	 */
    public String getShetuanhuodongPhoto() {
        return shetuanhuodongPhoto;
    }


    /**
	 * 设置：社团活动照片
	 */
    public void setShetuanhuodongPhoto(String shetuanhuodongPhoto) {
        this.shetuanhuodongPhoto = shetuanhuodongPhoto;
    }
    /**
	 * 获取：社团活动类型
	 */
    public Integer getShetuanhuodongTypes() {
        return shetuanhuodongTypes;
    }


    /**
	 * 设置：社团活动类型
	 */
    public void setShetuanhuodongTypes(Integer shetuanhuodongTypes) {
        this.shetuanhuodongTypes = shetuanhuodongTypes;
    }
    /**
	 * 获取：最大活动人数
	 */
    public Integer getShetuanhuodongZuida() {
        return shetuanhuodongZuida;
    }


    /**
	 * 设置：最大活动人数
	 */
    public void setShetuanhuodongZuida(Integer shetuanhuodongZuida) {
        this.shetuanhuodongZuida = shetuanhuodongZuida;
    }
    /**
	 * 获取：社团活动介绍
	 */
    public String getShetuanhuodongContent() {
        return shetuanhuodongContent;
    }


    /**
	 * 设置：社团活动介绍
	 */
    public void setShetuanhuodongContent(String shetuanhuodongContent) {
        this.shetuanhuodongContent = shetuanhuodongContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShetuanhuodongDelete() {
        return shetuanhuodongDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShetuanhuodongDelete(Integer shetuanhuodongDelete) {
        this.shetuanhuodongDelete = shetuanhuodongDelete;
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
