package com.ymcc.suser.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.common.result.PageList;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.AccountFlow;
import com.ymcc.pojo.query.AccountFlowQuery;
import com.ymcc.suser.service.IAccountFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountFlow")
public class AccountFlowController {

    @Autowired
    public IAccountFlowService accountFlowService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody AccountFlow accountFlow){
        if(accountFlow.getId()!=null){
            accountFlowService.updateById(accountFlow);
        }else{
            accountFlowService.saveOrUpdate(accountFlow);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        accountFlowService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(accountFlowService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(accountFlowService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody AccountFlowQuery query){
        Page<AccountFlow> page = new Page<AccountFlow>(query.getPage(),query.getRows());
        page = accountFlowService.page(page);
        return ResponseResult.success(new PageList<AccountFlow>(page.getTotal(),page.getRecords()));
    }
}
