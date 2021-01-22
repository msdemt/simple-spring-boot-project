package org.msdemt.simple.swagger_demo.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 9147523532722269351L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(8) COMMENT '姓名'")
    private String name;

    @Column(name = "age", columnDefinition = "VARCHAR(3) COMMENT '年龄'")
    private Integer age;

    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '地址'")
    private String address;
}
