package com.ymcc.apiuaa;

import com.ymcc.common.result.ResponseResult;
import com.ymcc.pojo.domain.Login;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/29 06:54
 */
@FeignClient("service-uaa")
public interface LoginFeignAPI {
    /**
     * UAA 调用
     * @param login 登录信息
     * @return 成功
     */
    @RequestMapping(value="/login/register",method= RequestMethod.POST)
    ResponseResult register(@RequestBody Login login);
}
