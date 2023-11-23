package org.javaboy.common.utils;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class PlatformResult<T> {

    private boolean success;

    private T data;

    private String errorCode;

    private String errorMsg;

    public static <T> PlatformResult<T> success(T data){
        PlatformResult<T> result = new PlatformResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }


    public static <T> PlatformResult<T> fail(String errorMsg){
        PlatformResult<T> result = new PlatformResult<>();
        result.setSuccess(false);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public static <T> PlatformResult<T> fail(String errorCode,String errorMsg){
        PlatformResult<T> result = new PlatformResult<>();
        result.setSuccess(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }




}
