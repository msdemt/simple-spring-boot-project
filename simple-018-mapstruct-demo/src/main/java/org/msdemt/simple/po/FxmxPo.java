package org.msdemt.simple.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 风险模型表（fxsj_fxmx）对应实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FxmxPo {
    /**
     * 模型ID
     */
    private String mxid;
    /**
     * 模型名称
     */
    private String mxmc;
    /**
     * 规则id集合
     */
    private String gzid;
    /**
     * 成立条件
     */
    private Integer cltj;
    /**
     * 风险等级
     */
    private String fxdj;
    /**
     * 启用标志
     */
    private String qybz;
    /**
     * 模型描述
     */
    private String mxms;
    /**
     * 创建时间
     */
    private Date cjsj;
    /**
     * 更新时间
     */
    private Date gxsj;
    /**
     * 操作人
     */
    private String czr;
}
