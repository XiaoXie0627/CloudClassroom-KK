package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.UserAddress;
import com.ymcc.pojo.query.UserAddressQuery;
import com.ymcc.service.service.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @Autowired
    public IUserAddressService userAddressService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody UserAddress userAddress){
        if(userAddress.getId()!=null){
            userAddressService.updateById(userAddress);
        }else{
            userAddressService.saveOrUpdate(userAddress);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        userAddressService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(userAddressService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(userAddressService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody UserAddressQuery query){
        Page<UserAddress> page = new Page<UserAddress>(query.getPage(),query.getRows());
        page = userAddressService.page(page);
        return ResponseResult.success(new PageList<UserAddress>(page.getTotal(),page.getRecords()));
    }
}
