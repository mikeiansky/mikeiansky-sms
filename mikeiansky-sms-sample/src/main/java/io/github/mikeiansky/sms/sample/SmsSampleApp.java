package io.github.mikeiansky.sms.sample;

import io.github.mikeiansky.sms.service.LianluSmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@SpringBootApplication
public class SmsSampleApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SmsSampleApp.class, args);
        TestService testService = context.getBean(TestService.class);
        testService.sendLianluTemplateSmsMessage();
    }

}
