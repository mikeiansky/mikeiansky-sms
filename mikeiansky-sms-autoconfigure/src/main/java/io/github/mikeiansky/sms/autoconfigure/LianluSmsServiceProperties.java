package io.github.mikeiansky.sms.autoconfigure;

import com.lianlu.config.LianluAppProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Data
@ConfigurationProperties(prefix = "io.github.mikeiansky.sms.lianlu")
public class LianluSmsServiceProperties {

    private Map<String, LianluAppProperties> app;

}
