package org.msdemt.simple.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 规则配置表（fxsj_gzpz）对应实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GzpzPo {
    /**
     * 规则ID
     */
    private String gzid;
    /**
     * 规则名称
     */
    private String gzmc;
    /**
     * 表达式
     */
    private String bds;
    /**
     * 用户类型
     */
    private String yhlx;
    /**
     * 属性来源表
     */
    private String sxlyb;
    /**
     * 属性字段
     */
    private String sxzd;
    /**
     * 规则描述
     */
    private String gzms;
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
