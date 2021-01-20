package org.msdemt.simple.mybatis_not_use_interface_proxy_demo.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6151537955659372302L;

    private Integer id;
    private String name;
    private Integer age;
    private String address;
}
