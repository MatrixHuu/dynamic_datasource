package com.javaboy.dd.service;

import com.javaboy.dd.annotation.DataSource;
import com.javaboy.dd.mapper.SlaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 20:37
 */
@Service
public class SlaveService {
    @Autowired
    SlaveMapper slaveMapper;
    @DataSource("slave")
    public void updateUserAge(String username, Integer age) {
        slaveMapper.updateUserAge(username, age);
        int i = 1 / 0;
    }
}
