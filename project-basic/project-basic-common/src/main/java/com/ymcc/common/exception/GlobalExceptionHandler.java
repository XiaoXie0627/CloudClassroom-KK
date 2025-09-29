package com.ymcc.common.exception;

import com.ymcc.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Valid;
import java.util.List;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(NotLoginException.class)
//    public ResponseResult<?> notLoginException(NotLoginException e) {
//        log.error("NotLoginException", e);
//        return ResultUtils.error(ErrorCode.NOT_LOGIN_ERROR, e.getMessage());
//    }
//
//    @ExceptionHandler(NotPermissionException.class)
//    public ResponseResult<?> notPermissionExceptionHandler(NotPermissionException e) {
//        log.error("NotPermissionException", e);
//        return ResultUtils.error(ErrorCode.NO_AUTH_ERROR, e.getMessage());
//    }

    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResponseResult.error(e.getMessage(), String.valueOf(e.getCode()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResponseResult.error("系统错误", String.valueOf(ErrorCode.SYSTEM_ERROR.getCode()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("ValidException", e);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        //这不是八股 为什么要使用StringBuilder 对于常变的字符串使用StringBuilder提升效率 减少String内存池的占用
        StringBuilder validMessage = new StringBuilder();
        allErrors.stream()
                .map(ObjectError::getDefaultMessage)
                .forEach(msg -> validMessage.append(msg).append("和"));

        // 如果需要去除最后一个多余的"和"
        if (validMessage.length() > 0) {
            validMessage.setLength(validMessage.length() - 1);
        }
        return ResponseResult.error("" + validMessage, String.valueOf(ErrorCode.VALIDOPERATION_ERROR.getCode()));
    }
}
