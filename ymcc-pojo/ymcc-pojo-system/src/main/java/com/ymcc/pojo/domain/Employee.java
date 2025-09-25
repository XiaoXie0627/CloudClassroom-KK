package com.ymcc.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
@TableName("t_employee")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 电话
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    @TableField("input_time")
    private LocalDateTime inputTime;
    /**
     * 状态：0正常，1锁定，2注销
     */
    private Integer state;
    /**
     * 部门id
     */
    @TableField("dept_id")
    private Long deptId;
    /**
     * 员工类型 ， 1平台普通员工 ，2平台客服人员，3平台管理员，4机构员工，5,机构管理员或其他
     */
    private Integer type;
    @TableField("login_id")
    private Long loginId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getInputTime() {
        return inputTime;
    }

    public void setInputTime(LocalDateTime inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
        ", id=" + id +
        ", realName=" + realName +
        ", tel=" + tel +
        ", email=" + email +
        ", inputTime=" + inputTime +
        ", state=" + state +
        ", deptId=" + deptId +
        ", type=" + type +
        ", loginId=" + loginId +
        "}";
    }
}
