package io.github.mikeiansky.sms.service;

import com.alibaba.fastjson.JSONObject;
import com.lianlu.common.Credential;
import com.lianlu.config.LianluAppProperties;
import com.lianlu.models.SmsSend;
import com.lianlu.param.LianluTemplateSmsParam;

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

    public void sendTemplateSms(LianluTemplateSmsParam param){
        LianluAppProperties appProperties = appPropertiesMap.get(param.getApp());

        Credential credential = new Credential(
                appProperties.getMchId(),
                appProperties.getAppid(),
                appProperties.getSecurityKey()
        );

        SmsSend s = new SmsSend();
        s.setTemplateParamSet(param.getParams());
        s.setPhoneNumberSet(param.getMobiles());
        s.setTemplateId(param.getTemplateId());
        JSONObject re = null;
        try {
            re = s.TemplateSend(credential, s);
            System.out.println("send result : " + re);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
