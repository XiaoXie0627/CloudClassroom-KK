package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseDetail;
import com.ymcc.pojo.query.CourseDetailQuery;
import com.ymcc.scourse.service.ICourseDetailService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RestController
@RequestMapping("/courseDetail")
public class CourseDetailController {

    @Autowired
    public ICourseDetailService courseDetailService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseDetail courseDetail){
        if(courseDetail.getId()!=null){
            courseDetailService.updateById(courseDetail);
        }else{
            courseDetailService.saveOrUpdate(courseDetail);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseDetailService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseDetailService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseDetailService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseDetailQuery query){
        Page<CourseDetail> page = new Page<CourseDetail>(query.getPage(),query.getRows());
        page = courseDetailService.page(page);
        return ResponseResult.success(new PageList<CourseDetail>(page.getTotal(),page.getRecords()));
    }
}
