package org.javaboy.common.utils.exception;

/**
 * @author:majin.wj
 */
public class BizException extends RuntimeException{

    public String message;

    public BizException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
