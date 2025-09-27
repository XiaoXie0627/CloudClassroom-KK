package com.ymcc.suaa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.Menu;
import com.ymcc.suaa.mapper.MenuMapper;
import com.ymcc.suaa.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
