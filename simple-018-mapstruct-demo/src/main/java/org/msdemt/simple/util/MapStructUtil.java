package org.msdemt.simple.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.msdemt.simple.dto.RiskModelManageReqDto;
import org.msdemt.simple.dto.RiskModelRespDto;
import org.msdemt.simple.dto.RuleManageReqDto;
import org.msdemt.simple.dto.RuleRespDto;
import org.msdemt.simple.po.FxmxPo;
import org.msdemt.simple.po.GzpzPo;

import java.util.ArrayList;

@Mapper(componentModel = "spring", imports = {JsonUtil.class, ArrayList.class},uses = DateMapper.class)
public interface MapStructUtil {

    @Mappings({
            @Mapping(source = "gzid", target = "ruleId"),
            @Mapping(source = "gzmc", target = "ruleName"),
            @Mapping(source = "yhlx", target = "userType"),
            @Mapping(source = "bds", target = "function"),
            @Mapping(source = "sxlyb", target = "dataSource"),
            @Mapping(source = "sxzd", target = "fieldName"),
            @Mapping(source = "gxsj", target = "updateTime"),
            @Mapping(source = "czr", target = "operator"),
            @Mapping(source = "gzms", target = "description"),
    })
    RuleRespDto toRuleDto(GzpzPo gzpzPo);

    @Mappings({
            @Mapping(source = "ruleId", target = "gzid"),
            @Mapping(source = "ruleName", target = "gzmc"),
            @Mapping(source = "userType", target = "yhlx"),
            @Mapping(source = "function", target = "bds"),
            @Mapping(source = "dataSource", target = "sxlyb"),
            @Mapping(source = "fieldName", target = "sxzd"),
            @Mapping(source = "description", target = "gzms"),
    })
    GzpzPo toGzpzPo(RuleManageReqDto manageRequest);

    @Mappings({
            @Mapping(source = "mxid", target = "modelId"),
            @Mapping(source = "mxmc", target = "modelName"),
            //@Mapping(source = "gzid", target = "ruleIds"),
            @Mapping(expression = "java(JsonUtil.string2Obj(fxmxPo.getGzid(), ArrayList.class))", target = "ruleIds"),
            @Mapping(source = "qybz", target = "state"),
            @Mapping(source = "fxdj", target = "riskLevel"),
            @Mapping(source = "cltj", target = "condition"),
            @Mapping(source = "gxsj", target = "updateTime"),
            @Mapping(source = "czr", target = "operator"),
            @Mapping(source = "mxms", target = "description"),
    })
    RiskModelRespDto toRiskModelDto(FxmxPo fxmxPo);


    @Mappings({
            @Mapping(source = "modelId", target = "mxid"),
            @Mapping(source = "modelName", target = "mxmc"),
            // @Mapping(source = "ruleIds", target = "gzid"),
            @Mapping(expression = "java(JsonUtil.obj2String(manageRequest.getRuleIds()))", target = "gzid"),
            @Mapping(source = "condition", target = "cltj"),
            @Mapping(source = "riskLevel", target = "fxdj"),
            @Mapping(source = "state", target = "qybz"),
            @Mapping(source = "description", target = "mxms"),
    })
    FxmxPo toFxmxPo(RiskModelManageReqDto manageRequest);
}
