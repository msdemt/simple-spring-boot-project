package org.msdemt.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RiskModelManageReqDto {

    /**
     * 操作类型
     */
    @NotBlank(message = "5111")
    @Pattern(regexp = "^[0-1]$", message = "5111")
    private String operateType;
    /**
     * 模型ID
     */
    @Length(max = 23, message = "5120")
    private String modelId;
    /**
     * 模型名称
     */
    @NotBlank(message = "5121")
    @Length(min = 1, max = 100, message = "5121")
    private String modelName;
    /**
     * 应用场景
     */
    @NotBlank(message = "5122")
    @Pattern(regexp = "^[0]$", message = "5122")
    private String application;
    /**
     * 启用状态
     */
    @NotBlank(message = "5123")
    @Pattern(regexp = "^[0-1]$", message = "5123")
    private String state;
    /**
     * 风险等级
     */
    @NotBlank(message = "5124")
    @Pattern(regexp = "^[0-4]$", message = "5124")
    private String riskLevel;
    /**
     * 规则id集合
     */
    private List<String> ruleIds;
    /**
     * 成立条件
     */
    @Length(max = 3, message = "5125")
    private String condition;
    /**
     * 描述
     */
    @Length(max = 255, message = "5126")
    private String description;
}
