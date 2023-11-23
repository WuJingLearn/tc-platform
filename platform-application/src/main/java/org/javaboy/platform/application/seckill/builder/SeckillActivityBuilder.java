package org.javaboy.platform.application.seckill.builder;

import org.javaboy.platform.application.seckill.commond.SeckillActivityCommand;
import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;
import org.springframework.beans.BeanUtils;

/**
 * @author:majin.wj
 */
public class SeckillActivityBuilder {

    public static SeckillActivity toSeckillActivity(SeckillActivityCommand activityCommand) {
        if (activityCommand == null) {
            return null;
        }
        SeckillActivity seckillActivity = new SeckillActivity();
        BeanUtils.copyProperties(activityCommand, seckillActivity);
        return seckillActivity;
    }

}
