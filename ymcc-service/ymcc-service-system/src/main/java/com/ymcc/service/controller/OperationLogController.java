package com.ymcc.service.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.service.service.IOperationLogService;
import com.ymcc.pojo.domain.OperationLog;
import com.ymcc.pojo.query.OperationLogQuery;
import com.ymcc.common.result.PageList;
import io.swagger.annotations.Api;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operationLog")
@Api("日志相关接口")
public class OperationLogController {

    @Autowired
    public IOperationLogService operationLogService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody OperationLog operationLog){
        if(operationLog.getId()!=null){
            operationLogService.updateById(operationLog);
        }else{
            operationLogService.save(operationLog);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        operationLogService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(operationLogService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(operationLogService.list());
    }


    /**
    * 带条件分页查询数据
    */
    //TODO
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody OperationLogQuery query){
        Page<OperationLog> page = new Page<OperationLog>(query.getPage(),query.getRows());
        page = operationLogService.page(page);
        return ResponseResult.success(new PageList<OperationLog>(page.getTotal(),page.getRecords()));
    }
}
