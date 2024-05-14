package com.entity.vo;

import com.entity.ShetuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社团
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shetuan")
public class ShetuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 团长
     */

    @TableField(value = "tuanzhang_id")
    private Integer tuanzhangId;


    /**
     * 社团名称
     */

    @TableField(value = "shetuan_name")
    private String shetuanName;


    /**
     * 社团照片
     */

    @TableField(value = "shetuan_photo")
    private String shetuanPhoto;


    /**
     * 社团类型
     */

    @TableField(value = "shetuan_types")
    private Integer shetuanTypes;


    /**
     * 社团人数
     */

    @TableField(value = "shetuan_renshu")
    private Integer shetuanRenshu;


    /**
     * 点击次数
     */

    @TableField(value = "shetuan_clicknum")
    private Integer shetuanClicknum;


    /**
     * 社团详情
     */

    @TableField(value = "shetuan_content")
    private String shetuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shetuan_delete")
    private Integer shetuanDelete;


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
    public Integer getTuanzhangId() {
        return tuanzhangId;
    }


    /**
	 * 获取：团长
	 */

    public void setTuanzhangId(Integer tuanzhangId) {
        this.tuanzhangId = tuanzhangId;
    }
    /**
	 * 设置：社团名称
	 */
    public String getShetuanName() {
        return shetuanName;
    }


    /**
	 * 获取：社团名称
	 */

    public void setShetuanName(String shetuanName) {
        this.shetuanName = shetuanName;
    }
    /**
	 * 设置：社团照片
	 */
    public String getShetuanPhoto() {
        return shetuanPhoto;
    }


    /**
	 * 获取：社团照片
	 */

    public void setShetuanPhoto(String shetuanPhoto) {
        this.shetuanPhoto = shetuanPhoto;
    }
    /**
	 * 设置：社团类型
	 */
    public Integer getShetuanTypes() {
        return shetuanTypes;
    }


    /**
	 * 获取：社团类型
	 */

    public void setShetuanTypes(Integer shetuanTypes) {
        this.shetuanTypes = shetuanTypes;
    }
    /**
	 * 设置：社团人数
	 */
    public Integer getShetuanRenshu() {
        return shetuanRenshu;
    }


    /**
	 * 获取：社团人数
	 */

    public void setShetuanRenshu(Integer shetuanRenshu) {
        this.shetuanRenshu = shetuanRenshu;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getShetuanClicknum() {
        return shetuanClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setShetuanClicknum(Integer shetuanClicknum) {
        this.shetuanClicknum = shetuanClicknum;
    }
    /**
	 * 设置：社团详情
	 */
    public String getShetuanContent() {
        return shetuanContent;
    }


    /**
	 * 获取：社团详情
	 */

    public void setShetuanContent(String shetuanContent) {
        this.shetuanContent = shetuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShetuanDelete() {
        return shetuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShetuanDelete(Integer shetuanDelete) {
        this.shetuanDelete = shetuanDelete;
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
