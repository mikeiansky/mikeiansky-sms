package com.lianlu.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
public class LianluResponseUtils {

    public static boolean isOk(JSONObject response) {
        return "00".equals(response.getString("status"));
    }

}
