package org.msdemt.simple;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class HutoolApplication {

    JSONObject jsonObject = JSONUtil.parseObj("123");
    String uid = jsonObject.getStr("uid");
}
