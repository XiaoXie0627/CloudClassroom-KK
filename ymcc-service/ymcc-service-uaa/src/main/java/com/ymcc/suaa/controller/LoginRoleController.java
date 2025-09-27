package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.LoginRole;
import com.ymcc.pojo.query.LoginRoleQuery;
import com.ymcc.suaa.service.ILoginRoleService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginRole")
public class LoginRoleController {

    @Autowired
    public ILoginRoleService loginRoleService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody LoginRole loginRole){
        if(loginRole.getId()!=null){
            loginRoleService.updateById(loginRole);
        }else{
            loginRoleService.saveOrUpdate(loginRole);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        loginRoleService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(loginRoleService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(loginRoleService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody LoginRoleQuery query){
        Page<LoginRole> page = new Page<LoginRole>(query.getPage(),query.getRows());
        page = loginRoleService.page(page);
        return ResponseResult.success(new PageList<LoginRole>(page.getTotal(),page.getRecords()));
    }
}
