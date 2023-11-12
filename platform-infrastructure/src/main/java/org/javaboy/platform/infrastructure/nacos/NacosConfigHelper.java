package org.javaboy.platform.infrastructure.nacos;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/**
 * @author:majin.wj
 */
@Slf4j
@Component
public class NacosConfigHelper {

    private static final String group = "platform";
    private static final long timeoutMs = 3000;

    @Autowired
    private ConfigService configService;

    private Map<String, String> dataCache = new ConcurrentHashMap<>();

    public String getData(String dataId) {
        String data = dataCache.get(dataId);
        if (data != null) {
            return data;
        }
        synchronized (this) {
            if (dataCache.get(dataId) != null) {
                return dataCache.get(dataId);
            }
            try {
                data = configService.getConfigAndSignListener(dataId, group, timeoutMs, new DataChangeListener(dataId));
                dataCache.put(dataId, data);
                return data;
            } catch (NacosException e) {
                log.error("get nacos data error dataId:{}", dataId, e);
                return null;
            }
        }
    }

    class DataChangeListener implements Listener {
        private String dataId;
        public DataChangeListener(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public Executor getExecutor() {
            return null;
        }

        @Override
        public void receiveConfigInfo(String configInfo) {
            dataCache.put(dataId, configInfo);
        }
    }

}
