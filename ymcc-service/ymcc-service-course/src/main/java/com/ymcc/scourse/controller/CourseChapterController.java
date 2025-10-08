package com.ymcc.scourse.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.CourseChapter;
import com.ymcc.pojo.query.CourseChapterQuery;
import com.ymcc.scourse.service.ICourseChapterService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseChapter")
public class CourseChapterController {

    @Autowired
    public ICourseChapterService courseChapterService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseChapter courseChapter){
        if(courseChapter.getId()!=null){
            courseChapterService.updateById(courseChapter);
        }else{
            courseChapterService.saveOrUpdate(courseChapter);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseChapterService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseChapterService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseChapterService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseChapterQuery query){
        Page<CourseChapter> page = new Page<CourseChapter>(query.getPage(),query.getRows());
        page = courseChapterService.page(page);
        return ResponseResult.success(new PageList<CourseChapter>(page.getTotal(),page.getRecords()));
    }
}
