package org.javaboy.platform.application.gamecenter.model.config;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author:majin.wj
 */
@Data
public class GameActivityConfig {

    private String activityName;

    private String activityDesc;

    private Date startTime;

    private Date endTime;

    private List<AwardConfig> awardConfigs;

}
