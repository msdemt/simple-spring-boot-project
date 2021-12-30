package org.msdemt.simple.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    //@JsonProperty("NAME")
    private String name;
    //@JsonProperty("年龄")
    private Integer age;
    //@JsonProperty("储蓄")
    private BigDecimal money;

    //@JsonProperty("first_name")
    private String firstName;

    private String HOBBY;

    private Date birthday;
}
