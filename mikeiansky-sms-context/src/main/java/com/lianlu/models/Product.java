package com.lianlu.models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianlu.common.*;
import com.lianlu.domain.Template;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private static final String prefix = "sms/product/";

    /**
     * 获取余额
     */
    public JSONObject GetBalance(Credential credential) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("balance");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 获取签名列表
     */
    public JSONObject GetSign(Credential credential) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("sign/get");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 获取签名列表
     */
    public JSONObject GetSign(Credential credential, int signId) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("sign/get");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("SignId", signId);
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 创建签名
     */
    public JSONObject CreateSign(Credential credential, Sign sign) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("sign/create");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("content", sign.getContent());
        if (sign.getType() != null) {
            requestData.put("type", sign.getType());
        }
        if (sign.getRemark() != null) {
            requestData.put("remark", sign.getRemark());
        }
        if (sign.getCreditCodeUrl() != null) {
            requestData.put("creditCodeUrl", sign.getCreditCodeUrl());
        }
        if (sign.getIdCardFront() != null) {
            requestData.put("idCardFront", sign.getIdCardFront());
        }
        if (sign.getIdCardBack() != null) {
            requestData.put("idCardBack", sign.getIdCardBack());
        }

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 获取模板列表
     */
    public JSONObject GetTemplates(Credential credential) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("template/get");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 获取单个模板
     */
    public JSONObject GetTemplate(Credential credential, int TemplateId) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("template/getById");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("TemplateId", TemplateId);

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 创建模板
     */
    public JSONObject CreateTemplate(Credential credential, int signId, String templateName, String content) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("template/create");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("SignId", signId);
        requestData.put("TemplateName", templateName);
        requestData.put("content", content);

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 创建模板
     */
    public JSONObject UpdateTemplate(Credential credential, Template template) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("template/update");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("TemplateId", template.getTemplateId());
        if (template.getTemplateName() != null) {
            requestData.put("TemplateName", template.getTemplateName());
        }
        if (template.getTemplateName() != null) {
            requestData.put("content", template.getContent());
        }
        if (template.getSignId() != null) {
            requestData.put("SignId", template.getSignId());
        }

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }

    /**
     * 创建模板
     */
    public JSONObject DeleteTemplate(Credential credential, Integer templateId) throws Exception {
        String url = Constants.DOMAIN_API.concat(prefix).concat("template/delete");

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("MchId", credential.getMchId());
        requestData.put("AppId", credential.getAppId());
        requestData.put("Version", credential.getVersion());
        requestData.put("SignType", credential.getSignType());
        requestData.put("TimeStamp", String.valueOf(SystemClock.now()));
        requestData.put("TemplateId", templateId);

        requestData.put("Signature", Encoder.generateSignature(requestData, credential.getAppKey(), credential.getSignType()));
        return Request.requestOnce(url, JSON.toJSONString(requestData), credential.isHttp(), 10000, 10000);
    }
}
