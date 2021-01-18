package com.example.simple.mybatis_project.test;

import com.example.simple.mybatis_project.dao.entity.User;
import com.example.simple.mybatis_project.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@SpringBootTest
public class MybatisProjectTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDataSource(){
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from t_user");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String address = resultSet.getString(4);
                log.info("---> id:" + id + ", name:" + name + ", age:" + age + ", address:" + address);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testUserMapper(){
        User user = userMapper.getUserById(1);
        log.info("---> id:" + user.getId() + ", name:" + user.getName() + ", age:" + user.getAge() + ", address:" + user.getAddress());
    }

}
