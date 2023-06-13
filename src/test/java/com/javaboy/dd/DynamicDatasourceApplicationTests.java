package com.javaboy.dd;

import com.javaboy.dd.annotation.DataSource;
import com.javaboy.dd.model.User;
import com.javaboy.dd.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DataSource("slave")
class DynamicDatasourceApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
