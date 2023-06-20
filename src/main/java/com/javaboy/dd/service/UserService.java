package com.javaboy.dd.service;

import com.javaboy.dd.annotation.DataSource;
import com.javaboy.dd.mapper.UserMapper;
import com.javaboy.dd.model.User;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/12 20:06
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MasterService masterService;
    @Autowired
    SlaveService slaveService;

//    @Transactional
    @GlobalTransactional
    public void test() {
        masterService.updateUserAge("javaboy", 200);
        slaveService.updateUserAge("zhangsan", 200);
    }


    @DataSource("master")
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
