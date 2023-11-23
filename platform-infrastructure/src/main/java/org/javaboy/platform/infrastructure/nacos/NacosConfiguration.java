package org.javaboy.platform.infrastructure.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.javaboy.common.utils.DebugLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:majin.wj
 */
@Configuration
public class NacosConfiguration {

    @Value("${nacos.serverAddr}")
    public String serverAddr;

    @Bean
    public ConfigService configService() {
        try {
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            DebugLogger.info("NacosConfig创建成功");
            return configService;
        } catch (NacosException e) {
            DebugLogger.error("Nacos启动失败," + e.getMessage());
            return null;
        }
    }

}
