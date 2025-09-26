package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.Config;
import com.ymcc.service.service.IConfigService;
import com.ymcc.pojo.query.ConfigQuery;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
@Api("配置接口")
public class ConfigController {

    @Autowired
    public IConfigService configService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Config config){
        if(config.getId()!=null){
            configService.updateById(config);
        }else{
            configService.save(config);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        configService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(configService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(configService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody ConfigQuery query){
        Page<Config> page = new Page<Config>(query.getPage(),query.getRows());
        page = configService.page(page);
        return ResponseResult.success(new PageList<Config>(page.getTotal(),page.getRecords()));
    }
}
