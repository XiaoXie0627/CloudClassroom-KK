package com.ymcc.common.result;

import lombok.Data;

/**
 * 响应封装结果
 */
@Data
public class ResponseResult {

    private boolean success = true;

    private String message = "成功";

    //错误码，用来描述错误类型 ，20000 表示么有错误
    private String code = "20000";

    //返回的数据 也可以做泛型处理
    private Object data;

    /** 创建当前实例 **/
    public static ResponseResult success(){
        return new ResponseResult();
    }
    /** 创建当前实例 **/
    public static ResponseResult success(Object obj){
        ResponseResult instance = new ResponseResult();
        instance.setData(obj);
        return instance;
    }

    public static ResponseResult success(Object obj, String code){
        ResponseResult instance = new ResponseResult();
        instance.setCode(code);
        instance.setData(obj);
        return instance;
    }
    /** 创建当前实例 **/

    public static ResponseResult error(String message, String code){
        ResponseResult instance = new ResponseResult();
        instance.setMessage(message);
        instance.setSuccess(false);
        instance.setCode(code);
        return instance;
    }

    public static ResponseResult error(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(false);
        return responseResult;
    }

    /** 创建当前实例 **/
    public static ResponseResult error(String message){
        return error(message,null);
    }

//    public static JSONResult error(CommonErrorCode errorCode){
//        return error(errorCode.getMesssage(),errorCode.getCode());
//    }


}
