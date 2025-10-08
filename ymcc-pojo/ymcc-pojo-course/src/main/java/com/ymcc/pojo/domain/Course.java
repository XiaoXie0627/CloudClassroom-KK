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
 * @since 2025-10-08
 */
@TableName("t_course")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 适用人群
     */
    @TableField("for_user")
    private String forUser;
    /**
     * 课程分类
     */
    @TableField("course_type_id")
    private Long courseTypeId;
    @TableField("grade_name")
    private String gradeName;
    /**
     * 课程等级
     */
    @TableField("grade_id")
    private Long gradeId;
    /**
     * 课程状态，下线：0 ， 上线：1
     */
    private Integer status;
    /**
     * 添加课程的后台用户的ID
     */
    @TableField("login_id")
    private Long loginId;
    /**
     * 添加课程的后台用户
     */
    @TableField("login_user_name")
    private String loginUserName;
    /**
     * 课程的开课时间
     */
    @TableField("start_time")
    private LocalDateTime startTime;
    /**
     * 课程的节课时间
     */
    @TableField("end_time")
    private LocalDateTime endTime;
    /**
     * 封面，云存储地址
     */
    private String pic;
    /**
     * 时长，以分钟为单位
     */
    @TableField("total_minute")
    private Integer totalMinute;
    @TableField("online_time")
    private LocalDateTime onlineTime;
    /**
     * 章节数
     */
    @TableField("chapter_count")
    private Integer chapterCount;
    /**
     * 讲师，逗号分隔多个
     */
    @TableField("teacher_names")
    private String teacherNames;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForUser() {
        return forUser;
    }

    public void setForUser(String forUser) {
        this.forUser = forUser;
    }

    public Long getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(Long courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getTotalMinute() {
        return totalMinute;
    }

    public void setTotalMinute(Integer totalMinute) {
        this.totalMinute = totalMinute;
    }

    public LocalDateTime getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(LocalDateTime onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public String getTeacherNames() {
        return teacherNames;
    }

    public void setTeacherNames(String teacherNames) {
        this.teacherNames = teacherNames;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Course{" +
        ", id=" + id +
        ", name=" + name +
        ", forUser=" + forUser +
        ", courseTypeId=" + courseTypeId +
        ", gradeName=" + gradeName +
        ", gradeId=" + gradeId +
        ", status=" + status +
        ", loginId=" + loginId +
        ", loginUserName=" + loginUserName +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", pic=" + pic +
        ", totalMinute=" + totalMinute +
        ", onlineTime=" + onlineTime +
        ", chapterCount=" + chapterCount +
        ", teacherNames=" + teacherNames +
        "}";
    }
}
