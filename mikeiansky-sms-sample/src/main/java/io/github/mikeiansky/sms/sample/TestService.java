package io.github.mikeiansky.sms.sample;

import com.lianlu.param.LianluTemplateSmsParam;
import io.github.mikeiansky.sms.service.LianluSmsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private String mobile;

    @Value("${template-id}")
    private String templateId;

    @Value("${app}")
    private String app;

    public TestService(LianluSmsService lianluSmsService) {
        this.lianluSmsService = lianluSmsService;
    }

    public void sendLianluTemplateSmsMessage() {
        System.out.println("tag ------ > " + tag);

        LianluTemplateSmsParam param = new LianluTemplateSmsParam();
        param.setTemplateId(templateId);
        param.setParams(new String[]{
                "name-01",
                "job-02"
        });
        param.setMobiles(new String[]{mobile});
        param.setApp(app);
        lianluSmsService.sendTemplateSms(param);
    }

}
