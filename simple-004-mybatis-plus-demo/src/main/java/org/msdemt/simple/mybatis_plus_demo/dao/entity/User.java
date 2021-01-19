package org.msdemt.simple.mybatis_plus_demo.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 8540409139254284576L;

    private Integer id;

    private String name;

    private Integer age;

    private String address;
}
