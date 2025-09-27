package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.UserGrowLog;
import com.ymcc.pojo.query.UserGrowLogQuery;
import com.ymcc.service.service.IUserGrowLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userGrowLog")
public class UserGrowLogController {

    @Autowired
    public IUserGrowLogService userGrowLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody UserGrowLog userGrowLog){
        if(userGrowLog.getId()!=null){
            userGrowLogService.updateById(userGrowLog);
        }else{
            userGrowLogService.saveOrUpdate(userGrowLog);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        userGrowLogService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(userGrowLogService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(userGrowLogService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody UserGrowLogQuery query){
        Page<UserGrowLog> page = new Page<UserGrowLog>(query.getPage(),query.getRows());
        page = userGrowLogService.page(page);
        return ResponseResult.success(new PageList<UserGrowLog>(page.getTotal(),page.getRecords()));
    }
}
