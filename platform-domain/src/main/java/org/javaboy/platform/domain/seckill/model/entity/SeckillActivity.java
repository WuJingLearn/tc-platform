package org.javaboy.platform.domain.seckill.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
public class SeckillActivity {

    private Long id;

    private String activityName;

    private Date startTime;

    private Date endTime;

    /**
     * 活动状态
     */
    private Integer status;

    private String activityDesc;
}
