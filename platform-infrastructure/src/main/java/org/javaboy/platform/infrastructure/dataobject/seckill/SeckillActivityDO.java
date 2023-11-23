package org.javaboy.platform.infrastructure.dataobject.seckill;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
@TableName("seckill_activity")
public class SeckillActivityDO {

    private Long id;

    private String activityName;

    private Date startTime;

    private Date endTime;

    /**
     * 活动状态
     */
    private Integer status;

    private String activityDesc;


    private Date gmtCreate;

    private Date gmtModified;

    private String isDeleted;
}
