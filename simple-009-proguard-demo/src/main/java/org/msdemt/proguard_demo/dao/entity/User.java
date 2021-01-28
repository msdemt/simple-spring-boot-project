package org.msdemt.proguard_demo.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 4130110927059793026L;

    @Id //主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(8) COMMENT '姓名'")
    private String name;

    @Column(name = "age", columnDefinition = "INT(2) COMMENT '年龄'")
    private Integer age;

    @Column(name = "address", columnDefinition = "VARCHAR(255) COMMENT '地址'")
    private String address;

}
