package com.ymcc.suaa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.LoginLog;
import com.ymcc.suaa.mapper.LoginLogMapper;
import com.ymcc.suaa.service.ILoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {

}
