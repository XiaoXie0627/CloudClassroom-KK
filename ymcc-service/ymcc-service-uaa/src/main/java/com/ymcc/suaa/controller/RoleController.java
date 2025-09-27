package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.Role;
import com.ymcc.pojo.query.RoleQuery;
import com.ymcc.suaa.service.IRoleService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    public IRoleService roleService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Role role){
        if(role.getId()!=null){
            roleService.updateById(role);
        }else{
            roleService.saveOrUpdate(role);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        roleService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(roleService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(roleService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody RoleQuery query){
        Page<Role> page = new Page<Role>(query.getPage(),query.getRows());
        page = roleService.page(page);
        return ResponseResult.success(new PageList<Role>(page.getTotal(),page.getRecords()));
    }
}
