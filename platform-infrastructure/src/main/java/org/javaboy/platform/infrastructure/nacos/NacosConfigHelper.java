package org.javaboy.platform.infrastructure.nacos;

import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
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
    /**
     * 缓存不存在配置项key，防止不断请求nacos
     */
    private static final String EMP_CONFIG_CACHE = "$empty$";

    @Autowired
    private NacosConfigSeriviceMock configService;

    private Map<String, String> dataCache = new ConcurrentHashMap<>();

    public String getData(String dataId) {
        String data = dataCache.get(dataId);
        if (Objects.equals(data, EMP_CONFIG_CACHE)) {
            return null;
        }
        if (data != null) {
            return data;
        }
        synchronized (this) {
            if (dataCache.get(dataId) != null) {
                return dataCache.get(dataId);
            }
            try {
                data = configService.getConfigAndSignListener(dataId, group, timeoutMs, new DataChangeListener(dataId));
                if (StringUtils.isBlank(data)) {
                    data = EMP_CONFIG_CACHE;
                }
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
