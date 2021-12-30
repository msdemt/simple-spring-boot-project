package org.msdemt.simple.enums;

public enum ErrorCode {
    SUCCESS(1000,"成功"),

    LEG_NOTNULL_PAGENUM(4338,"当前页码不能为空"),
    LEG_NOTNULL_PAGESIZE(4339,"每页条数不能为空"),

    LEG_NOTBLANK_STIME(5101,"起始时间不能为空"),
    LEG_LENGTHERR_STIME(5102,"起始时间格式错误（YYYY-MM-DD）"),
    LEG_NOTBLANK_ETIME(5103,"终止时间不能为空"),
    LEG_LENGTHERR_ETIME(5104,"终止时间格式错误（YYYY-MM-DD）"),
    LEG_NOTBLANK_TYPE(5105,"类型不能为空"),
    LEG_LENGTHERR_TYPE(5106,"类型长度错误或无效"),
    LEG_NOTBLANK_TIME(5107,"所选时间不能为空"),
    LEG_LENGTHERR_TIME(5108,"所选时间格式错误（YYYY-MM）"),

    INVALID_OPERATE_TYPE(5111, "操作类型字段不合法"),
    INVALID_RULE_ID(5112, "规则ID字段不合法"),
    INVALID_RULE_NAME(5113, "规则名称字段不合法"),
    INVALID_USER_Type(5114, "适用人员类型字段不合法"),
    INVALID_FUNCTION(5115, "表达式字段不合法"),
    INVALID_Data_Source(5116, "数据来源表字段不合法"),
    INVALID_Field_NAME(5117, "数据来源字段不合法"),
    INVALID_DESCRIPTION(5118, "描述字段不合法"),
    NOT_FOUND_USER_INFO(5119, "未获取到用户信息"),
    INVALID_MODEL_ID(5120, "模型ID字段不合法"),
    INVALID_MODEL_NAME(5121, "模型名称字段不合法"),
    INVALID_APPLICATION_NAME(5122, "应用场景字段不合法"),
    INVALID_STATE_NAME(5123, "启用状态字段不合法"),
    INVALID_RISK_LEVEL_NAME(5124, "风险等级字段不合法"),
    INVALID_CONDITION_NAME(5125, "成立条件字段不合法"),
    INVALID_DESC_NAME(5126, "描述字段不合法"),

    STA_ERR_STATS_TYPE(5190,"统计时间类型错误"),


    STA_ERROR(5999,"服务异常");


    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public  static ErrorCode getGeneralStatusCode(int code) {
        for (ErrorCode ele : values()) {
            if(ele.getCode()==code) return ele;
        }
        return null;
    }
}
