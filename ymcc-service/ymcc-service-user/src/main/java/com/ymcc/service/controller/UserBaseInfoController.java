package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.UserBaseInfo;
import com.ymcc.pojo.query.UserBaseInfoQuery;
import com.ymcc.service.service.IUserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userBaseInfo")
public class UserBaseInfoController {

    @Autowired
    public IUserBaseInfoService userBaseInfoService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody UserBaseInfo userBaseInfo){
        if(userBaseInfo.getId()!=null){
            userBaseInfoService.updateById(userBaseInfo);
        }else{
            userBaseInfoService.saveOrUpdate(userBaseInfo);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        userBaseInfoService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(userBaseInfoService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(userBaseInfoService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody UserBaseInfoQuery query){
        Page<UserBaseInfo> page = new Page<UserBaseInfo>(query.getPage(),query.getRows());
        page = userBaseInfoService.page(page);
        return ResponseResult.success(new PageList<UserBaseInfo>(page.getTotal(),page.getRecords()));
    }
}
