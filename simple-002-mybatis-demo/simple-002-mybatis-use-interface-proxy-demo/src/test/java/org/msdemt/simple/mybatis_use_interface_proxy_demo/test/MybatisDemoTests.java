package org.msdemt.simple.mybatis_use_interface_proxy_demo.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.entity.User;
import org.msdemt.simple.mybatis_use_interface_proxy_demo.dao.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@SpringBootTest
public class MybatisDemoTests {

    @Resource
    private DataSource dataSource;
    @Resource
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
