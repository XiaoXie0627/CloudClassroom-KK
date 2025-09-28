package com.ymcc.scommon.service;

import org.springframework.stereotype.Service;

/**
* @author Light xhh032533@163.com   
* @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
* @time 2025/9/27 21:22
*/
public interface VerifyCodeService {

    void sendSmsCode(String phone);
}
