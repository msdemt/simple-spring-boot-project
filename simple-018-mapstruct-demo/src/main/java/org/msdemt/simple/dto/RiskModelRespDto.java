package org.msdemt.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskModelRespDto {
    /**
     * 模型ID
     */
    private String modelId;
    /**
     * 模型名称
     */
    private String modelName;
    /**
     * 应用场景
     */
    private String application;
    /**
     * 启用状态
     */
    private String state;
    /**
     * 风险等级
     */
    private String riskLevel;
    /**
     * 规则名id集合
     */
    private List<String> ruleIds;
    /**
     * 规则名集合
     */
    private List<String> ruleNames;
    /**
     * 成立条件
     */
    private String condition;
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
