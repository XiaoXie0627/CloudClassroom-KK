package com.ymcc.common.exception;
import com.ymcc.common.result.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return ResponseResult.error( e.getMessage(),String.valueOf(e.getCode()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseResult runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResponseResult.error("系统错误",String.valueOf(ErrorCode.SYSTEM_ERROR.getCode()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("ValidException", e);
        return ResponseResult.error("系统错误",String.valueOf(ErrorCode.SYSTEM_ERROR.getCode()));
    }
}
