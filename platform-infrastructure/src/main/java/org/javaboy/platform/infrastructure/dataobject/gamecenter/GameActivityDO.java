package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
public class GameActivityDO {

    private Long id;

    private String activityName;

    private String activityDesc;

    private int type;

    private Date startTime;

    private Date endTime;

}
