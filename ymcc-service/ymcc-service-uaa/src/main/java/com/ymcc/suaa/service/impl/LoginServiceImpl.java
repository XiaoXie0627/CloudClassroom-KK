package com.ymcc.suaa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.Login;
import com.ymcc.suaa.mapper.LoginMapper;
import com.ymcc.suaa.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {

}
