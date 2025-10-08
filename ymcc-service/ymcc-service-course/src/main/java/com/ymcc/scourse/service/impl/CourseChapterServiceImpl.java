package com.ymcc.scourse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.CourseChapter;
import com.ymcc.scourse.mapper.CourseChapterMapper;
import com.ymcc.scourse.service.ICourseChapterService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程章节 ， 一个课程，多个章节，一个章节，多个视频 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-10-08
 */
@Service
public class CourseChapterServiceImpl extends ServiceImpl<CourseChapterMapper, CourseChapter> implements ICourseChapterService {

}
