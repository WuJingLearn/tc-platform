package org.javaboy.common.utils.exception;

/**
 * @author:majin.wj
 */
public class BizException extends RuntimeException {

    public String code;

    public BizException(String message) {
        super(message);
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
