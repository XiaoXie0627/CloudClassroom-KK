package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseSummary;
import com.ymcc.pojo.query.CourseSummaryQuery;
import com.ymcc.scourse.service.ICourseSummaryService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseSummary")
public class CourseSummaryController {

    @Autowired
    public ICourseSummaryService courseSummaryService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseSummary courseSummary){
        if(courseSummary.getId()!=null){
            courseSummaryService.updateById(courseSummary);
        }else{
            courseSummaryService.saveOrUpdate(courseSummary);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseSummaryService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseSummaryService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseSummaryService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseSummaryQuery query){
        Page<CourseSummary> page = new Page<CourseSummary>(query.getPage(),query.getRows());
        page = courseSummaryService.page(page);
        return ResponseResult.success(new PageList<CourseSummary>(page.getTotal(),page.getRecords()));
    }
}
