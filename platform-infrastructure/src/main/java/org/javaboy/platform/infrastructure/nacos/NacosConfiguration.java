package org.javaboy.platform.infrastructure.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
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
            return NacosFactory.createConfigService(serverAddr);
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

}
