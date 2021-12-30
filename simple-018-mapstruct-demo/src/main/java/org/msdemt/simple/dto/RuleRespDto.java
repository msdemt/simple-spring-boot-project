package org.msdemt.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleRespDto {
    /**
     * 规则ID
     */
    private String ruleId;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 适用人员类型
     */
    private String userType;
    /**
     * 表达式
     */
    private String function;
    /**
     * 数据来源表
     */
    private String dataSource;
    /**
     * 来源字段名
     */
    private String fieldName;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新人
     */
    private String operator;
    /**
     * 描述
     */
    private String description;
}
