package com.ymcc.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2025-10-08
 */
@TableName("t_course_view_log")
public class CourseViewLog extends Model<CourseViewLog> {

    private static final long serialVersionUID = 1L;

    private Long id;
    @TableField("course_id")
    private Long courseId;
    @TableField("user_id")
    private Long userId;
    @TableField("create_time")
    private LocalDateTime createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CourseViewLog{" +
        ", id=" + id +
        ", courseId=" + courseId +
        ", userId=" + userId +
        ", createTime=" + createTime +
        "}";
    }
}
