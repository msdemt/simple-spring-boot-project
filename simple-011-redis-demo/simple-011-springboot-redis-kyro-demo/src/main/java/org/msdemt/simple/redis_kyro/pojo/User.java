package org.msdemt.simple.redis_kyro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    private Integer age;
    private String address;
}
