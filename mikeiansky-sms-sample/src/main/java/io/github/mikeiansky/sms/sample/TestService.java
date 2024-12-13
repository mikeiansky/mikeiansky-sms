package io.github.mikeiansky.sms.sample;

import io.github.mikeiansky.sms.service.LianluSmsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Service
public class TestService {

    private final LianluSmsService lianluSmsService;

    @Value("${tag}")
    private String tag;

    @Value("${mobile}")
    private String[] mobile;

    @Value("${app}")
    private String app;

    public TestService(LianluSmsService lianluSmsService) {
        this.lianluSmsService = lianluSmsService;
    }

    public void sendLianluTemplateSmsMessage() {
        System.out.println("tag ------ > " + tag);
    }

}
