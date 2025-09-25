package com.ymcc.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
@TableName("t_systemdictionaryitem")
public class Systemdictionaryitem extends Model<Systemdictionaryitem> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("parent_id")
    private Long parentId;
    private String name;
    /**
     * 排序
     */
    private Integer requence;
    private String intro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequence() {
        return requence;
    }

    public void setRequence(Integer requence) {
        this.requence = requence;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Systemdictionaryitem{" +
        ", id=" + id +
        ", parentId=" + parentId +
        ", name=" + name +
        ", requence=" + requence +
        ", intro=" + intro +
        "}";
    }
}
