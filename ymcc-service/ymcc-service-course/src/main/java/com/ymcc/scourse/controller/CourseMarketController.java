package com.ymcc.scourse.controller;

import com.ymcc.pojo.domain.CourseMarket;
import com.ymcc.pojo.query.CourseMarketQuery;
import com.ymcc.scourse.service.ICourseMarketService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseMarket")
public class CourseMarketController {

    @Autowired
    public ICourseMarketService courseMarketService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody CourseMarket courseMarket){
        if(courseMarket.getId()!=null){
            courseMarketService.updateById(courseMarket);
        }else{
            courseMarketService.saveOrUpdate(courseMarket);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        courseMarketService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(courseMarketService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(courseMarketService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody CourseMarketQuery query){
        Page<CourseMarket> page = new Page<CourseMarket>(query.getPage(),query.getRows());
        page = courseMarketService.page(page);
        return ResponseResult.success(new PageList<CourseMarket>(page.getTotal(),page.getRecords()));
    }
}
