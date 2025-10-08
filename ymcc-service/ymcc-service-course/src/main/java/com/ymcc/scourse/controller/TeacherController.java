package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.Teacher;
import com.ymcc.pojo.query.TeacherQuery;
import com.ymcc.scourse.service.ITeacherService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    public ITeacherService teacherService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Teacher teacher){
        if(teacher.getId()!=null){
            teacherService.updateById(teacher);
        }else{
            teacherService.saveOrUpdate(teacher);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        teacherService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(teacherService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(teacherService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody TeacherQuery query){
        Page<Teacher> page = new Page<Teacher>(query.getPage(),query.getRows());
        page = teacherService.page(page);
        return ResponseResult.success(new PageList<Teacher>(page.getTotal(),page.getRecords()));
    }
}
