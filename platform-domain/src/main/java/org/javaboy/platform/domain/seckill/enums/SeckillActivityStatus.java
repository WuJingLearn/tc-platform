package org.javaboy.platform.domain.seckill.enums;

/**
 * @author:majin.wj
 */
public enum SeckillActivityStatus {

    DRAFT(0, "草稿"),
    PUBLISH(1,"发布");

    private Integer status;
    private String desc;

    private SeckillActivityStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }
}
