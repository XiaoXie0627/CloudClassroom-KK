package com.ymcc.suaa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.LoginRole;
import com.ymcc.suaa.mapper.LoginRoleMapper;
import com.ymcc.suaa.service.ILoginRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色中间表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class LoginRoleServiceImpl extends ServiceImpl<LoginRoleMapper, LoginRole> implements ILoginRoleService {

}
