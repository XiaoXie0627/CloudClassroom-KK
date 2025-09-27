package com.ymcc.ssystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Systemdictionary;
import com.ymcc.pojo.query.SystemdictionaryQuery;
import com.ymcc.common.result.PageList;
import com.ymcc.ssystem.service.ISystemdictionaryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/systemdictionary")
@Api("系统数据字典相关接口")
public class SystemdictionaryController {

    @Autowired
    public ISystemdictionaryService systemdictionaryService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Systemdictionary systemdictionary){
        if(systemdictionary.getId()!=null){
            systemdictionaryService.updateById(systemdictionary);
        }else{
            systemdictionaryService.save(systemdictionary);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        systemdictionaryService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(systemdictionaryService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(systemdictionaryService.list());
    }


    /**
    * 带条件分页查询数据
    */
    //TODO
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody SystemdictionaryQuery query){
        Page<Systemdictionary> page = new Page<Systemdictionary>(query.getPage(),query.getRows());
        page = systemdictionaryService.page(page);
        return ResponseResult.success(new PageList<Systemdictionary>(page.getTotal(),page.getRecords()));
    }
}
