package com.example.simple.mybatis_plus.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8540409139254284576L;

    private Integer id;

    private String name;

    private Integer age;

    private String address;
}
