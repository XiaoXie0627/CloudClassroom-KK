package com.ymcc.ssystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Systemdictionaryitem;
import com.ymcc.pojo.query.SystemdictionaryitemQuery;
import com.ymcc.common.result.PageList;
import com.ymcc.ssystem.service.ISystemdictionaryitemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/systemdictionaryitem")
@Api("等级数据字典相关接口")
public class SystemdictionaryitemController {

    @Autowired
    public ISystemdictionaryitemService systemdictionaryitemService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Systemdictionaryitem systemdictionaryitem){
        if(systemdictionaryitem.getId()!=null){
            systemdictionaryitemService.updateById(systemdictionaryitem);
        }else{
            systemdictionaryitemService.save(systemdictionaryitem);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        systemdictionaryitemService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(systemdictionaryitemService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(systemdictionaryitemService.list());
    }


    /**
    * 带条件分页查询数据
    */
    //TODO
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody SystemdictionaryitemQuery query){
        Page<Systemdictionaryitem> page = new Page<Systemdictionaryitem>(query.getPage(),query.getRows());
        page = systemdictionaryitemService.page(page);
        return ResponseResult.success(new PageList<Systemdictionaryitem>(page.getTotal(),page.getRecords()));
    }
}
