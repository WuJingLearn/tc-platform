package org.javaboy.platform.infrastructure.nacos;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.apache.rocketmq.common.filter.impl.Op;
import org.javaboy.platform.domain.leaderboard.model.entity.LeaderBoardConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author:majin.wj
 */
@Component
public class NacosConfigSeriviceMock implements ConfigService {

    private Map<String, String> mockConfig = new HashMap<>();

    @PostConstruct
    public void init() {
        mockLeaderboardConfig();
    }

    private void mockLeaderboardConfig() {
        LeaderBoardConfig programmingLanguageConfig = new LeaderBoardConfig();
        programmingLanguageConfig.setBucket(2);
        programmingLanguageConfig.setLimit(10);
        programmingLanguageConfig.setScene("programmingLanguage");
        programmingLanguageConfig.setPeriod("week");
        mockConfig.put("programmingLanguage", JSON.toJSONString(programmingLanguageConfig));
    }


    @Autowired(required = false)
    private ConfigService configService;

    @Override
    public String getConfig(String dataId, String group, long timeoutMs) throws NacosException {
        return null;
    }

    @Override
    public String getConfigAndSignListener(String dataId, String group, long timeoutMs, Listener listener) throws NacosException {
        String data = mockConfig.get(dataId);
        if (Objects.nonNull(data)) {
            return data;
        }
        return configService.getConfigAndSignListener(dataId, group, timeoutMs, listener);
//        return Optional.ofNullable(mockConfig.get(dataId)).orElse(configService.getConfigAndSignListener(dataId, group, timeoutMs, listener));
    }

    @Override
    public void addListener(String dataId, String group, Listener listener) throws NacosException {

    }

    @Override
    public boolean publishConfig(String dataId, String group, String content) throws NacosException {
        return false;
    }

    @Override
    public boolean publishConfig(String dataId, String group, String content, String type) throws NacosException {
        return false;
    }

    @Override
    public boolean publishConfigCas(String dataId, String group, String content, String casMd5) throws NacosException {
        return false;
    }

    @Override
    public boolean publishConfigCas(String dataId, String group, String content, String casMd5, String type) throws NacosException {
        return false;
    }

    @Override
    public boolean removeConfig(String dataId, String group) throws NacosException {
        return false;
    }

    @Override
    public void removeListener(String dataId, String group, Listener listener) {

    }

    @Override
    public String getServerStatus() {
        return null;
    }

    @Override
    public void shutDown() throws NacosException {

    }
}
