package com.ymcc.scommon.service.impl;

import com.ymcc.common.Constants.BusinessConstants;
import com.ymcc.common.exception.BusinessException;
import com.ymcc.common.exception.ErrorCode;
import com.ymcc.common.util.AssertUtil;
import com.ymcc.common.util.CodeGenerateUtils;
import com.ymcc.common.util.VerifyCodeUtils;
import com.ymcc.scommon.dto.CodeDTO;
import com.ymcc.scommon.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/27 21:23
 */
@Service
@Slf4j
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    public RedisTemplate<Object,Object> redisTemplate;
    /**
     * 短信验证码
     * @param phone 电话
     */
    @Override
    public void sendSmsCode(String phone) {
        //1.校验电话号码  后期：正则表达式
        AssertUtil.isPhone(phone,"请输入正确的手机号格式");
        //Redis key：业务+phone  业务区分
        String key = BusinessConstants.SMS_CODE + phone;
        //2.验证码是否存在
        Object obj = redisTemplate.opsForValue().get(key);
        CodeDTO codeDTO = null;
        String smsCode = null;
        if (obj != null){
            //3.存在
            // 判断是否是一分钟内防重
            long currentTimes = Calendar.getInstance().getTimeInMillis();
            codeDTO = (CodeDTO) obj;
            if ((currentTimes - codeDTO.getTime())> 60*1000){
                throw new BusinessException(ErrorCode.DISABLE_CLICK);
            }
            smsCode = codeDTO.getCode();
            //将验证码返回并且刷新过期时间（复用Code节省资源）
        }
        else{
            //4.不存在
            //生成验证码存入Redis中并发送验证码短信，且通知用户发送成功
            smsCode = VerifyCodeUtils.generateVerifyCode(4);
        }
        redisTemplate.opsForValue().set(key,smsCode,5, TimeUnit.MINUTES);
        //短信服务
        log.info("发送验证码成功，请在5分钟内使用：{}",smsCode);
    }
}
