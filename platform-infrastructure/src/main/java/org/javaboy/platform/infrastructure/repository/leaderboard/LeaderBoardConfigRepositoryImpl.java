package org.javaboy.platform.infrastructure.repository.leaderboard;

import com.alibaba.fastjson.JSON;
import org.javaboy.common.utils.exception.BizException;
import org.javaboy.platform.domain.leaderboard.model.entity.LeaderBoardConfig;
import org.javaboy.platform.domain.leaderboard.repository.LeaderBoardConfigRepository;
import org.javaboy.platform.infrastructure.nacos.NacosConfigHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:majin.wj
 */
@Component
public class LeaderBoardConfigRepositoryImpl implements LeaderBoardConfigRepository {

    @Autowired
    private NacosConfigHelper nacosConfigHelper;
    @Override
    public LeaderBoardConfig getLeaderBoardConfig(String scene) {
        String config = nacosConfigHelper.getData(scene);
        if (config == null) {
            throw new BizException(String.format("场景%s排行榜配置不存在", scene));
        }
        return JSON.parseObject(config, LeaderBoardConfig.class);
    }
}
