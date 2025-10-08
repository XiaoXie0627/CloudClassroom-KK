package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseResource;
import com.ymcc.pojo.query.CourseResourceQuery;
import com.ymcc.scourse.service.ICourseResourceService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseResource")
public class CourseResourceController {

    @Autowired
    public ICourseResourceService courseResourceService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseResource courseResource){
        if(courseResource.getId()!=null){
            courseResourceService.updateById(courseResource);
        }else{
            courseResourceService.saveOrUpdate(courseResource);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseResourceService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseResourceService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseResourceService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseResourceQuery query){
        Page<CourseResource> page = new Page<CourseResource>(query.getPage(),query.getRows());
        page = courseResourceService.page(page);
        return ResponseResult.success(new PageList<CourseResource>(page.getTotal(),page.getRecords()));
    }
}
