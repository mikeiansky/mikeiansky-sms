package com.lianlu.models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianlu.common.*;

import java.util.HashMap;
import java.util.Map;

public class EmptyCheck {
    private String[] PhoneList;

    public String[] getPhoneList() {
        return PhoneList;
    }

    public void setPhoneList(String[] phoneList) {
        PhoneList = phoneList;
    }

    private static final String prefix = "empty/";

    public EmptyCheck() {
    }

    /**
     * 空号检测
     */
    public JSONObject Check(Credential credential, EmptyCheck source) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("api/check");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("PhoneList", source.getPhoneList());

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }
}
