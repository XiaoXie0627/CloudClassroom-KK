package com.ymcc.suser.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ymcc.pojo.domain.User;
import com.ymcc.pojo.dto.PhoneRegisterDTO;

import javax.validation.Valid;

/**
 * <p>
 * 会员登录账号 服务类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
public interface IUserService extends IService<User> {

    void phoneRegister(@Valid PhoneRegisterDTO phoneRegisterDTO);

}
