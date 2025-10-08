package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseTeacher;
import com.ymcc.pojo.query.CourseTeacherQuery;
import com.ymcc.scourse.service.ICourseTeacherService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseTeacher")
public class CourseTeacherController {

    @Autowired
    public ICourseTeacherService courseTeacherService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseTeacher courseTeacher){
        if(courseTeacher.getId()!=null){
            courseTeacherService.updateById(courseTeacher);
        }else{
            courseTeacherService.saveOrUpdate(courseTeacher);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseTeacherService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseTeacherService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseTeacherService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseTeacherQuery query){
        Page<CourseTeacher> page = new Page<CourseTeacher>(query.getPage(),query.getRows());
        page = courseTeacherService.page(page);
        return ResponseResult.success(new PageList<CourseTeacher>(page.getTotal(),page.getRecords()));
    }
}
