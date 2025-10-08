package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseViewLog;
import com.ymcc.pojo.query.CourseViewLogQuery;
import com.ymcc.scourse.service.ICourseViewLogService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseViewLog")
public class CourseViewLogController {

    @Autowired
    public ICourseViewLogService courseViewLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseViewLog courseViewLog){
        if(courseViewLog.getId()!=null){
            courseViewLogService.updateById(courseViewLog);
        }else{
            courseViewLogService.saveOrUpdate(courseViewLog);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseViewLogService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseViewLogService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseViewLogService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseViewLogQuery query){
        Page<CourseViewLog> page = new Page<CourseViewLog>(query.getPage(),query.getRows());
        page = courseViewLogService.page(page);
        return ResponseResult.success(new PageList<CourseViewLog>(page.getTotal(),page.getRecords()));
    }
}
