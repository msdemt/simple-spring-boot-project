package org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 6151537955659372302L;

    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
