package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.OauthCode;
import com.ymcc.pojo.query.OauthCodeQuery;
import com.ymcc.suaa.service.IOauthCodeService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauthCode")
public class OauthCodeController {

    @Autowired
    public IOauthCodeService oauthCodeService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody OauthCode oauthCode){
        if(oauthCode.getCode()!=null){
            oauthCodeService.updateById(oauthCode);
        }else{
            oauthCodeService.saveOrUpdate(oauthCode);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        oauthCodeService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(oauthCodeService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(oauthCodeService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody OauthCodeQuery query){
        Page<OauthCode> page = new Page<OauthCode>(query.getPage(),query.getRows());
        page = oauthCodeService.page(page);
        return ResponseResult.success(new PageList<OauthCode>(page.getTotal(),page.getRecords()));
    }
}
