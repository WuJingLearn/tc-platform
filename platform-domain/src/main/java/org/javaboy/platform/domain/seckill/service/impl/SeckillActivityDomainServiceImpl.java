package org.javaboy.platform.domain.seckill.service.impl;

import org.javaboy.common.utils.exception.BizException;
import org.javaboy.platform.domain.infra.message.MessageSenderService;
import org.javaboy.platform.domain.seckill.enums.SeckillActivityStatus;
import org.javaboy.platform.domain.seckill.event.SeckillActivityEvent;
import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;
import org.javaboy.platform.domain.seckill.repository.SeckillActivityRepository;
import org.javaboy.platform.domain.seckill.service.SeckillActivityDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author:majin.wj
 */
@Service
public class SeckillActivityDomainServiceImpl implements SeckillActivityDomainService {

    private static final Logger LOG = LoggerFactory.getLogger(SeckillActivityDomainService.class);

    @Autowired
    private SeckillActivityRepository seckillActivityRepository;

    @Autowired
    private MessageSenderService messageSenderService;
    @Override
    public void saveSeckillActivity(SeckillActivity seckillActivity) {
        seckillActivityRepository.saveSeckillActivity(seckillActivity);;
    }

    @Override
    public void publishSeckillActivity(Long activityId) {
        SeckillActivity seckillActivity = seckillActivityRepository.getSeckilllActivityById(activityId);
        if (seckillActivity == null) {
            throw new BizException("活动不存在");
        }
        if (Objects.equals(seckillActivity.getStatus(), SeckillActivityStatus.PUBLISH.getStatus())) {
            throw new RuntimeException("活动已经发布");
        }
        seckillActivity.setStatus(SeckillActivityStatus.PUBLISH.getStatus());
        seckillActivityRepository.updateSeckllActivity(seckillActivity);
        LOG.info("seckillActivityPublish|活动已发布完成｜{}",activityId);
        SeckillActivityEvent seckillActivityEvent = new SeckillActivityEvent(activityId, SeckillActivityStatus.PUBLISH.getStatus(), "activity");
        boolean sendResult = messageSenderService.sendMessage(seckillActivityEvent);
        LOG.info("seckillActivityPublush|事件发送{}",sendResult?"成功":"失败,请关注");
    }

    @Override
    public SeckillActivity getSeckillActivityById(Long activityId) {
        return seckillActivityRepository.getSeckilllActivityById(activityId);
    }
}
