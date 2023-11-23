package org.javaboy.platform.infrastructure.repository.seckill;

import org.javaboy.platform.domain.seckill.model.entity.SeckillActivity;
import org.javaboy.platform.domain.seckill.repository.SeckillActivityRepository;
import org.javaboy.platform.infrastructure.dao.seckill.SeckillActivityMapper;
import org.javaboy.platform.infrastructure.dataobject.seckill.SeckillActivityDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author:majin.wj
 */
@Repository
public class SeckillActivityRepositoryImpl implements SeckillActivityRepository {

    @Autowired
    private SeckillActivityMapper activityMapper;

    @Override
    public int saveSeckillActivity(SeckillActivity seckillActivity) {
        SeckillActivityDO seckillActivityDO = new SeckillActivityDO();
        BeanUtils.copyProperties(seckillActivity, seckillActivityDO);
        seckillActivityDO.setIsDeleted("n");
        seckillActivityDO.setGmtCreate(new Date());
        seckillActivityDO.setGmtModified(new Date());
        return activityMapper.insert(seckillActivityDO);
    }

    @Override
    public int updateSeckllActivity(SeckillActivity seckillActivity) {
        SeckillActivityDO seckillActivityDO = new SeckillActivityDO();
        BeanUtils.copyProperties(seckillActivity, seckillActivityDO);
        seckillActivityDO.setGmtModified(new Date());
        return activityMapper.updateById(seckillActivityDO);
    }

    @Override
    public SeckillActivity getSeckilllActivityById(Long activityId) {
        SeckillActivityDO seckillActivityDO = activityMapper.selectById(activityId);
        if (seckillActivityDO != null) {
            SeckillActivity seckillActivity = new SeckillActivity();
            BeanUtils.copyProperties(seckillActivityDO, seckillActivity);
            return seckillActivity;
        }
        return null;
    }
}
