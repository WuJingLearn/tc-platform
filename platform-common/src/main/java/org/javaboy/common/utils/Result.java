package org.javaboy.common.utils;

import lombok.Data;

/**
 * @author:majin.wj
 */
@Data
public class Result<T> {

    private boolean success;

    private T data;

    private String errorMsg;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }


    public static <T> Result<T> fail(String errorMsg){
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setErrorMsg(errorMsg);
        return result;
    }



}
