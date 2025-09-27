package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.RolePermission;
import com.ymcc.pojo.query.RolePermissionQuery;
import com.ymcc.suaa.service.IRolePermissionService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {

    @Autowired
    public IRolePermissionService rolePermissionService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody RolePermission rolePermission){
        if(rolePermission.getId()!=null){
            rolePermissionService.updateById(rolePermission);
        }else{
            rolePermissionService.saveOrUpdate(rolePermission);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        rolePermissionService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(rolePermissionService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(rolePermissionService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody RolePermissionQuery query){
        Page<RolePermission> page = new Page<RolePermission>(query.getPage(),query.getRows());
        page = rolePermissionService.page(page);
        return ResponseResult.success(new PageList<RolePermission>(page.getTotal(),page.getRecords()));
    }
}
