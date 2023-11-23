package org.javaboy.platform.application.seckill.service;

import org.javaboy.platform.application.seckill.commond.SeckillActivityCommand;

/**
 * @author:majin.wj
 */
public interface SeckillActivityService {

    boolean saveSeckillActivity(SeckillActivityCommand activityCommand);

    boolean publishSeckillActivity(Long activityId);

}
