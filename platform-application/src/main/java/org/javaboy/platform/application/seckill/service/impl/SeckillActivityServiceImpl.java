package org.javaboy.platform.application.seckill.service.impl;

import org.javaboy.platform.application.seckill.builder.SeckillActivityBuilder;
import org.javaboy.platform.application.seckill.commond.SeckillActivityCommand;
import org.javaboy.platform.application.seckill.service.SeckillActivityService;
import org.javaboy.platform.domain.seckill.enums.SeckillActivityStatus;
import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;
import org.javaboy.platform.domain.seckill.service.SeckillActivityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author:majin.wj
 */
@Service
public class SeckillActivityServiceImpl implements SeckillActivityService {


    @Autowired
    private SeckillActivityDomainService seckillActivityDomainService;

    @Override
    public boolean saveSeckillActivity(SeckillActivityCommand activityCommand) {
        Assert.notNull(activityCommand, "not null");

        SeckillActivity seckillActivity = SeckillActivityBuilder.toSeckillActivity(activityCommand);
        seckillActivity.setStatus(SeckillActivityStatus.DRAFT.getStatus());
        seckillActivityDomainService.saveSeckillActivity(seckillActivity);
        return true;
    }

    @Override
    public boolean publishSeckillActivity(Long activityId) {
        seckillActivityDomainService.publishSeckillActivity(activityId);
        return true;
    }
}
