package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * @author FJx 异常抛出类
 * @date 2019/2/15 9:47
 */
public class ExceptionCast {

    //使用此静态方法抛出自定义异常类
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
