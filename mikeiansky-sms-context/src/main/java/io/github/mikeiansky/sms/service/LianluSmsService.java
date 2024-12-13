package io.github.mikeiansky.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.lianlu.common.Credential;
import com.lianlu.config.LianluAppProperties;
import com.lianlu.models.SmsSend;
import com.lianlu.param.LianluTemplateSmsParam;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class LianluSmsService {

    private final Map<String, LianluAppProperties> appPropertiesMap;

    public LianluSmsService(Map<String, LianluAppProperties> appPropertiesMap) {
        this.appPropertiesMap = appPropertiesMap;
    }

    public JSONObject sendTemplateSms(LianluTemplateSmsParam param) {
        // params check
        Assert.notNull(param, "param must not be null");
        Assert.notNull(param.getTemplateId(), "templateId must not be null");
        Assert.notNull(param.getApp(), "app must not be null");
        Assert.notNull(param.getMobiles(), "mobiles must not be null");

        LianluAppProperties appProperties = appPropertiesMap.get(param.getApp());
        Assert.notNull(appProperties, "app properties not found for app: " + param.getApp());

        Credential credential = new Credential(
                appProperties.getMchId(),
                appProperties.getAppid(),
                appProperties.getSecurityKey()
        );

        SmsSend s = new SmsSend();
        s.setTemplateParamSet(param.getParams());
        s.setPhoneNumberSet(param.getMobiles());
        s.setTemplateId(param.getTemplateId());
        JSONObject result = null;
        try {
            result = s.TemplateSend(credential, s);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
