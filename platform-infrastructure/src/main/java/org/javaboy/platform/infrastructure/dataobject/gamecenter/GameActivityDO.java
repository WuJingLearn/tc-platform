package org.javaboy.platform.infrastructure.dataobject.gamecenter;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Data
@TableName("game_activity")
public class GameActivityDO {

    private Long id;

    private String activityName;

    private String activityDesc;

    private int type;

    private Date startTime;

    private Date endTime;

}
