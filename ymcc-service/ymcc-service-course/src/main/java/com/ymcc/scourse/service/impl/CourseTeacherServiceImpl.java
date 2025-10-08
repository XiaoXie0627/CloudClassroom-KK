package com.ymcc.scourse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.CourseTeacher;
import com.ymcc.scourse.mapper.CourseTeacherMapper;
import com.ymcc.scourse.service.ICourseTeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程和老师的中间表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-10-08
 */
@Service
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher> implements ICourseTeacherService {

}
