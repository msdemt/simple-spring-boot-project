package org.msdemt.simple.test;

import org.junit.jupiter.api.Test;
import org.msdemt.simple.dto.RuleRespDto;
import org.msdemt.simple.po.GzpzPo;
import org.msdemt.simple.util.JsonUtil;
import org.msdemt.simple.util.MapStructUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ConvertTest {

    @Autowired
    private MapStructUtil mapStructUtil;

    @Test
    public void test(){
        GzpzPo gzpzPo = new GzpzPo();
        gzpzPo.setGzid("111");
        gzpzPo.setGxsj(new Date());
        RuleRespDto ruleRespDto = mapStructUtil.toRuleDto(gzpzPo);
        System.out.println(ruleRespDto);
    }

    @Test
    public void jsonTest(){
        String build = JsonUtil.builder().put("name", "nike").put("age", "21").build();

    }
}
