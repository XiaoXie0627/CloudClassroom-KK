package com.ymcc.suser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.User;
import com.ymcc.suser.mapper.UserMapper;
import com.ymcc.suser.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员登录账号 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
