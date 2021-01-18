package com.example.simple.mybatis_project.dao.entity;

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
