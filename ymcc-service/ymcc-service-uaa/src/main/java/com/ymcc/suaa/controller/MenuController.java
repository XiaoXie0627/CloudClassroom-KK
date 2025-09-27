package com.ymcc.suaa.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymcc.pojo.domain.Menu;
import com.ymcc.pojo.query.MenuQuery;
import com.ymcc.suaa.service.IMenuService;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.common.result.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    public IMenuService menuService;

    /**
    * 保存和修改公用的
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public ResponseResult saveOrUpdate(@RequestBody Menu menu){
        if(menu.getId()!=null){
            menuService.updateById(menu);
        }else{
            menuService.saveOrUpdate(menu);
        }
        return ResponseResult.success();
    }

    /**
    * 删除对象
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseResult delete(@PathVariable("id") Long id){
        menuService.removeById(id);
        return ResponseResult.success();
    }

    /**
   * 获取对象
   */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseResult get(@PathVariable("id")Long id){
        return ResponseResult.success(menuService.getById(id));
    }


    /**
    * 查询所有对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseResult list(){
        return ResponseResult.success(menuService.list());
    }


    /**
    * 带条件分页查询数据
    */
    @RequestMapping(value = "/pagelist",method = RequestMethod.POST)
    public ResponseResult page(@RequestBody MenuQuery query){
        Page<Menu> page = new Page<Menu>(query.getPage(),query.getRows());
        page = menuService.page(page);
        return ResponseResult.success(new PageList<Menu>(page.getTotal(),page.getRecords()));
    }
}
