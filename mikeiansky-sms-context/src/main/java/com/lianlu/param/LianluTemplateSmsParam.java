package com.lianlu.param;

import lombok.Data;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Data
public class LianluTemplateSmsParam {

    private String app;
    private String[] mobiles;
    private String[] params;
    private String templateId;

}
