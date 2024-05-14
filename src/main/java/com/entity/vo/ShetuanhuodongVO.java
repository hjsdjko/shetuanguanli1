package com.entity.vo;

import com.entity.ShetuanhuodongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社团活动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shetuanhuodong")
public class ShetuanhuodongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
