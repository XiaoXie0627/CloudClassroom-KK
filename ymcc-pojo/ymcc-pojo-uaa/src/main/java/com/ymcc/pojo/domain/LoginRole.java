package com.ymcc.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户和角色中间表
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@TableName("t_login_role")
public class LoginRole extends Model<LoginRole> {

    private static final long serialVersionUID = 1L;

    @TableField("login_id")
    private Long loginId;
    @TableField("role_id")
    private Long roleId;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LoginRole{" +
        ", loginId=" + loginId +
        ", roleId=" + roleId +
        ", id=" + id +
        "}";
    }
}
