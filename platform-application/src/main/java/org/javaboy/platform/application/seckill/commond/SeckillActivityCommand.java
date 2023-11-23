package org.javaboy.platform.application.seckill.commond;

import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
public class SeckillActivityCommand {

    private String activityName;

    private Date startTime;

    private Date endTime;

    private String activityDesc;

}
