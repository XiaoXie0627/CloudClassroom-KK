package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

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
    //注册渠道
    @NotEmpty(message = "注册不能为空")
    String regChannel;
    //验证码
    @NotEmpty(message = "验证码不能为空")
    String smsCode;
}
