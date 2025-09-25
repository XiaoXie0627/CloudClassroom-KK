package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.service.service.IOperationLogService;
import com.ymcc.pojo.domain.OperationLog;
import com.ymcc.pojo.query.OperationLogQuery;
import com.ymcc.common.result.JSONResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operationLog")
public class OperationLogController {

    @Autowired
    public IOperationLogService operationLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public JSONResult saveOrUpdate(@RequestBody OperationLog operationLog){
        if(operationLog.getId()!=null){
            operationLogService.updateById(operationLog);
        }else{
            operationLogService.save(operationLog);
        }
        return JSONResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public JSONResult delete(@PathVariable("id") Long id){
        operationLogService.removeById(id);
        return JSONResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JSONResult get(@PathVariable("id")Long id){
        return JSONResult.success(operationLogService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public JSONResult list(){
        return JSONResult.success(operationLogService.list());
    }


    /**
    * 带条件分页查询数据
    */
    //TODO
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public JSONResult page(@RequestBody OperationLogQuery query){
        Page<OperationLog> page = new Page<OperationLog>(query.getPage(),query.getRows());
        page = operationLogService.page(page);
        return JSONResult.success(new PageList<OperationLog>(page.getTotal(),page.getRecords()));
    }
}
