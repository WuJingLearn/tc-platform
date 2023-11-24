package org.javaboy.platform.adapter.controller.seckill.admin;

import org.javaboy.common.utils.PlatformResult;
import org.javaboy.platform.application.seckill.commond.SeckillActivityCommand;
import org.javaboy.platform.application.seckill.service.SeckillActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:majin.wj
 * 内部管理接口
 */
@RequestMapping("/admin/seckill/activity")
@RestController
public class SeckillActivityAdminController {

    @Autowired
    private SeckillActivityService activityService;

    /**
     * 创建一个秒杀活动,草稿状态
     *
     * @return
     */
    @PostMapping("/saveSeckillActivity")
    public PlatformResult<Boolean> saveSeckillActivity(@RequestBody SeckillActivityCommand activityCommand) {
        return PlatformResult.success(activityService.saveSeckillActivity(activityCommand));
    }

    @PostMapping("/publishSeckillActivity")
    public PlatformResult<Boolean> publishSeckillActivityId(@RequestParam Long activityId) {
        return PlatformResult.success(activityService.publishSeckillActivity(activityId));
    }

}
