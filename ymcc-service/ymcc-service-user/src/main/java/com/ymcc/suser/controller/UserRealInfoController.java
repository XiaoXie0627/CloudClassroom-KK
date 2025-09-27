package com.ymcc.suser.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.UserRealInfo;
import com.ymcc.pojo.query.UserRealInfoQuery;
import com.ymcc.suser.service.IUserRealInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRealInfo")
public class UserRealInfoController {

    @Autowired
    public IUserRealInfoService userRealInfoService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody UserRealInfo userRealInfo){
        if(userRealInfo.getId()!=null){
            userRealInfoService.updateById(userRealInfo);
        }else{
            userRealInfoService.saveOrUpdate(userRealInfo);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        userRealInfoService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(userRealInfoService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(userRealInfoService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody UserRealInfoQuery query){
        Page<UserRealInfo> page = new Page<UserRealInfo>(query.getPage(),query.getRows());
        page = userRealInfoService.page(page);
        return ResponseResult.success(new PageList<UserRealInfo>(page.getTotal(),page.getRecords()));
    }
}
