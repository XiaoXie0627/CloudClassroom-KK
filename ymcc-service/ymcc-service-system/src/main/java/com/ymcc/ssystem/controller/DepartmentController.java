package com.ymcc.ssystem.controller;

import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Department;
import com.ymcc.pojo.query.DepartmentQuery;
import com.ymcc.ssystem.service.IDepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Api("部门相关接口")
public class DepartmentController {

    @Autowired
    public IDepartmentService departmentService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Department department){
        if(department.getId()!=null){
            departmentService.updateById(department);
        }else{
            departmentService.save(department);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        departmentService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(departmentService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(departmentService.list());
    }


    /**
    * 带条件分页查询数据 根据部门名排序
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody DepartmentQuery query){
        PageList<Department> pageList = departmentService.pageQuery(query);
        return ResponseResult.success(pageList);
    }
}
