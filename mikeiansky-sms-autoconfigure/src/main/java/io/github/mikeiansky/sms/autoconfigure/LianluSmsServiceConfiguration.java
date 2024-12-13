package io.github.mikeiansky.sms.autoconfigure;

import io.github.mikeiansky.sms.service.LianluSmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Configuration
@EnableConfigurationProperties(LianluSmsServiceProperties.class)
public class LianluSmsServiceConfiguration {

    @Bean
    @ConditionalOnMissingBean(LianluSmsService.class)
    public LianluSmsService lianluSmsService(final LianluSmsServiceProperties properties) {
        LianluSmsService lianluSmsService = new LianluSmsService(properties.getApp());
        return lianluSmsService;
    }

}
