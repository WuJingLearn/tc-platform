package org.javaboy.common.utils.exception;

/**
 * @author:majin.wj
 */
public enum BizExceptionEnums {

    CONFIG_NOT_EXIST("CONFIG_NOT_EXIST", "配置不存在"),
    ACTIVITY_TIME_ILLEGAL("ACTIVITY_TIME_ILLEGAL","活动不在有效时间")
    ;
    private String code;
    private String desc;

    private BizExceptionEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
