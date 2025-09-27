package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.Permission;
import com.ymcc.pojo.query.PermissionQuery;
import com.ymcc.suaa.service.IPermissionService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    public IPermissionService permissionService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Permission permission){
        if(permission.getId()!=null){
            permissionService.updateById(permission);
        }else{
            permissionService.saveOrUpdate(permission);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        permissionService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(permissionService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(permissionService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody PermissionQuery query){
        Page<Permission> page = new Page<Permission>(query.getPage(),query.getRows());
        page = permissionService.page(page);
        return ResponseResult.success(new PageList<Permission>(page.getTotal(),page.getRecords()));
    }
}
