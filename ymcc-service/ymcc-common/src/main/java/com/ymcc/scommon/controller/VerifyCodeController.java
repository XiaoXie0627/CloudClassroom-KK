package com.ymcc.scommon.controller;

import com.ymcc.common.result.ResponseResult;
import com.ymcc.scommon.service.VerifyCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码服务
 */
@RestController
@RequestMapping("/verifycode")
@Api("验证码相关接口")
public class VerifyCodeController {
    @Autowired
    public VerifyCodeService  verifyCodeService;

    @ApiOperation("生成和发送验证码")
    @GetMapping("sendSmsCode/{phone}")
    public ResponseResult sendSmsCode(@PathVariable String phone){
        verifyCodeService.sendSmsCode(phone);
        return ResponseResult.success();
    }
}
