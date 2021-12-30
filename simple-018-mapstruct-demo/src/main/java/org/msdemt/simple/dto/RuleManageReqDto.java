package org.msdemt.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RuleManageReqDto {
    /**
     * 操作类型
     */
    @NotBlank(message = "5111")
    @Pattern(regexp = "^[0-1]$", message = "5111")
    private String operateType;
    /**
     * 规则ID
     */
    //@NotBlank(message = "5112", groups = RuleValidGroup.CRUD.Update.class)
    @Length(max = 23, message = "5112")
    private String ruleId;
    /**
     * 规则名称
     */
    @NotBlank(message = "5113")
    @Length(min = 1, max = 100, message = "5113")
    private String ruleName;
    /**
     * 适用人员类型
     */
    @NotBlank(message = "5114")
    @Pattern(regexp = "^[0-1]$", message = "5114")
    private String userType;
    /**
     * 表达式
     */
    @NotBlank(message = "5115")
    @Pattern(regexp = "^(>|<|=|in)$", message = "5115")
    private String function;
    /**
     * 数据来源表
     */
    @NotBlank(message = "5116")
    @Length(min = 1, max = 25, message = "5116")
    private String dataSource;
    /**
     * 来源字段名
     */
    @NotBlank(message = "5117")
    @Length(min = 1, max = 25, message = "5117")
    private String fieldName;
    /**
     * 描述
     */
    @Length(max = 255, message = "5118")
    private String description;
}
