package com.ymcc.scourse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.CourseType;
import com.ymcc.scourse.mapper.CourseTypeMapper;
import com.ymcc.scourse.service.ICourseTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-10-08
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

}
