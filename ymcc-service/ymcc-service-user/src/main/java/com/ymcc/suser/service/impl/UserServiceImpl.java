package com.ymcc.suser.service.impl;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.apiuaa.LoginFeignAPI;
import com.ymcc.common.Constants.BusinessConstants;
import com.ymcc.common.dto.CodeDTO;
import com.ymcc.common.exception.BusinessException;
import com.ymcc.common.exception.ErrorCode;
import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Login;
import com.ymcc.pojo.domain.User;
import com.ymcc.pojo.domain.UserAccount;
import com.ymcc.pojo.domain.UserBaseInfo;
import com.ymcc.suser.mapper.UserMapper;
import com.ymcc.suser.service.IUserAccountService;
import com.ymcc.suser.service.IUserBaseInfoService;
import com.ymcc.suser.service.IUserService;
import com.ymcc.pojo.dto.PhoneRegisterDTO;
import io.seata.spring.annotation.GlobalTransactional;
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
    @Autowired
    public IUserAccountService accountService;
    @Autowired
    public IUserBaseInfoService baseInfoService;

    /**
     * 手机号注册
     * @param phoneRegisterDTO 参数
     */
    @GlobalTransactional
    @Override
    public void phoneRegister(PhoneRegisterDTO phoneRegisterDTO) {
        //1.校验验证码
        String key = BusinessConstants.SMS_CODE + phoneRegisterDTO.getMobile();
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj == null){
            throw new BusinessException(ErrorCode.EXCEPTION_SMSCODE,"验证码已经过期，请点击重新发送");
        }
        CodeDTO codeDTO = (CodeDTO) obj;
        if (!codeDTO.getCode().equals(phoneRegisterDTO.getSmsCode())){
            throw new BusinessException(ErrorCode.EXCEPTION_SMSCODE,"请输入正确的验证码");
        }
        //2.校验手机号
        User user = this.lambdaQuery().eq(User::getPhone, phoneRegisterDTO.getMobile()).one();
        if (user != null){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"该手机号已经注册");
        }
        //3.DB操作 远程调用  t_user,t_user_account,t_user_bse_info,t_login
        //MP字段回显
        //3,1 先操作login表 得到字段login_id
        //todo 密码加密
        Login login = new Login();
        login.setUsername(phoneRegisterDTO.getMobile());
        login.setPassword(phoneRegisterDTO.getPassword());
        login.setType(1);
        login.setEnabled(true);
        login.setAccountNonExpired(true);
        login.setCredentialsNonExpired(true);
        login.setAccountNonLocked(true);
        //分布式事务场景 只要不是本地数据库 就需要分布式事务解决 ：1.跨服务 2.跨数据库
        ResponseResult jsonResult = loginFeignAPI.register(login);
        //是序列化后的字符串
        Object jsonResultData = jsonResult.getData();
        String jsonString = JSONObject.toJSONString(jsonResultData);
        Login loginFromDB = JSONObject.parseObject(jsonString, Login.class);
        Long loginId = loginFromDB.getId();
        //复制给user的loginId user表插入数据
        User userSave = new User();
        long now = new Date().getTime();
        userSave.setCreateTime(now);
        userSave.setUpdateTime(now);
        userSave.setPhone(phoneRegisterDTO.getMobile());
        userSave.setNickName(phoneRegisterDTO.getMobile());
        userSave.setBitState(0L);
        userSave.setSecLevel(0);
        userSave.setLoginId(loginId);
        save(userSave);
        //userCount表
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userSave.getId());
        userAccount.setUsableAmount(new BigDecimal(0));
        userAccount.setFrozenAmount(new BigDecimal(0));
        userAccount.setCreateTime(now);
        userAccount.setUpdateTime(now);
        userAccount.setPassword(phoneRegisterDTO.getPassword());
        accountService.save(userAccount);
        //UserBaseInfo表
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setId(userSave.getId());
        userBaseInfo.setCreateTime(now);
        userBaseInfo.setUpdateTime(now);
        userBaseInfo.setRegChannel(phoneRegisterDTO.getRegChannel());
        baseInfoService.save(userBaseInfo);
        redisTemplate.delete(key);
    }
}
