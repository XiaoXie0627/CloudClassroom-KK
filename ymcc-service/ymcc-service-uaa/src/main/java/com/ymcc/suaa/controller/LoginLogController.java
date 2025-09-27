package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.LoginLog;
import com.ymcc.pojo.query.LoginLogQuery;
import com.ymcc.suaa.service.ILoginLogService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Autowired
    public ILoginLogService loginLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody LoginLog loginLog){
        if(loginLog.getId()!=null){
            loginLogService.updateById(loginLog);
        }else{
            loginLogService.saveOrUpdate(loginLog);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        loginLogService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(loginLogService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(loginLogService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody LoginLogQuery query){
        Page<LoginLog> page = new Page<LoginLog>(query.getPage(),query.getRows());
        page = loginLogService.page(page);
        return ResponseResult.success(new PageList<LoginLog>(page.getTotal(),page.getRecords()));
    }
}
