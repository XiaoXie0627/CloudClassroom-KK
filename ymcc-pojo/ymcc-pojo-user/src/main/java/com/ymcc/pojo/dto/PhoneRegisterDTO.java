package com.ymcc.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Light xhh032533@163.com
 * @time 2025/9/29 06:06
 * 手机号注册
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRegisterDTO {
    //手机号
    @NotEmpty(message = "手机号不能为空")
    String mobile;
    //密码
    @NotEmpty(message = "密码不能为空")
    String password;
    //注册渠道 可以写校验规则
    @NotNull(message = "注册不能为空")
    Integer regChannel;
    //验证码 可以写校验规则
    @NotEmpty(message = "验证码不能为空")
    String smsCode;
}
