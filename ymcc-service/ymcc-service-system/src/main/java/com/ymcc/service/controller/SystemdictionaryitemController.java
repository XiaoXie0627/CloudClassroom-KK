package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.service.service.ISystemdictionaryitemService;
import com.ymcc.pojo.domain.Systemdictionaryitem;
import com.ymcc.pojo.query.SystemdictionaryitemQuery;
import com.ymcc.common.result.JSONResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/systemdictionaryitem")
public class SystemdictionaryitemController {

    @Autowired
    public ISystemdictionaryitemService systemdictionaryitemService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody Systemdictionaryitem systemdictionaryitem){
        if(systemdictionaryitem.getId()!=null){
            systemdictionaryitemService.updateById(systemdictionaryitem);
        }else{
            systemdictionaryitemService.save(systemdictionaryitem);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        systemdictionaryitemService.removeById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(systemdictionaryitemService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(systemdictionaryitemService.list());
    }


    /**
    * 带条件分页查询数据
    */
    //TODO
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody SystemdictionaryitemQuery query){
        Page<Systemdictionaryitem> page = new Page<Systemdictionaryitem>(query.getPage(),query.getRows());
        page = systemdictionaryitemService.page(page);
        return JSONResult.success(new PageList<Systemdictionaryitem>(page.getTotal(),page.getRecords()));
    }
}
