package org.msdemt.simple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RuleListQueryReqDto {

    /**
     * 当前页码
     */
    @NotNull(message = "5109")
    private Integer pageNum;
    /**
     * 每页条数
     */
    @NotNull(message = "5110")
    private Integer pageSize;
}
