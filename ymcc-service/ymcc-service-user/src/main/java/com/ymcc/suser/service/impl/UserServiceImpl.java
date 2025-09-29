package com.ymcc.suser.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.classfile.Code;
import com.ymcc.apiuaa.LoginFeignAPI;
import com.ymcc.common.Constants.BusinessConstants;
import com.ymcc.common.dto.CodeDTO;
import com.ymcc.common.exception.BusinessException;
import com.ymcc.common.exception.ErrorCode;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Login;
import com.ymcc.pojo.domain.User;
import com.ymcc.suser.mapper.UserMapper;
import com.ymcc.suser.service.IUserService;
import dto.PhoneRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    @Autowired
    public RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    public LoginFeignAPI loginFeignAPI;
    /**
     * 手机号注册
     * @param phoneRegisterDTO 参数
     */
    @Override
    public void phoneRegister(PhoneRegisterDTO phoneRegisterDTO) {
        //1.校验验证码
        Object obj = redisTemplate.opsForValue().get(BusinessConstants.SMS_CODE + phoneRegisterDTO.getMobile());
        if (obj == null){
            throw new BusinessException(ErrorCode.EXCEPTION_SMSCODE,"验证码已经过期，请点击重新发送");
        }
        CodeDTO codeDTO = (CodeDTO) obj;
        if (!codeDTO.getCode().equals(phoneRegisterDTO.getSmsCode())){
            throw new BusinessException(ErrorCode.EXCEPTION_SMSCODE,"请输入正确的验证码");
        }
        //2.校验手机号
        User user = this.lambdaQuery().eq(User::getPhone, phoneRegisterDTO.getMobile()).getEntity();
        if (user != null){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"该手机号已经注册");
        }
        //3.DB操作 远程调用  t_user,t_user_account,t_user_bse_info,t_login
        //MP字段回显
        //3,1 先操作login表 得到字段login_id
        Login login = new Login();
        login.setUsername(phoneRegisterDTO.getMobile());
        login.setPassword(phoneRegisterDTO.getPassword());
        login.setType(1);
        login.setEnabled(true);
        login.setAccountNonExpired(true);
        login.setCredentialsNonExpired(true);
        login.setAccountNonLocked(true);
        ResponseResult jsonResult = loginFeignAPI.register(login);
        //是序列化后的字符串
        Object jsonResultData = jsonResult.getData();
        String jsonString = JSONObject.toJSONString(jsonResultData);
        Login loginFromDB = JSONObject.parseObject(jsonString, Login.class);
        Long loginId = loginFromDB.getId();
        //复制给user的loginId
        //TODO user表的插入数据

    }
}
