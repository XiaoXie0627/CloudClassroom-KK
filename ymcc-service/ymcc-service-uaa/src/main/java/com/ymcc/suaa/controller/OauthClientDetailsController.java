package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.OauthClientDetails;
import com.ymcc.suaa.service.IOauthClientDetailsService;
import com.ymcc.common.query.OauthClientDetailsQuery;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauthClientDetails")
public class OauthClientDetailsController {

    @Autowired
    public IOauthClientDetailsService oauthClientDetailsService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody OauthClientDetails oauthClientDetails){
        if(oauthClientDetails.getClientId()!=null){
            oauthClientDetailsService.updateById(oauthClientDetails);
        }else{
            oauthClientDetailsService.saveOrUpdate(oauthClientDetails);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        oauthClientDetailsService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(oauthClientDetailsService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(oauthClientDetailsService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody OauthClientDetailsQuery query){
        Page<OauthClientDetails> page = new Page<OauthClientDetails>(query.getPage(),query.getRows());
        page = oauthClientDetailsService.page(page);
        return ResponseResult.success(new PageList<OauthClientDetails>(page.getTotal(),page.getRecords()));
    }
}
