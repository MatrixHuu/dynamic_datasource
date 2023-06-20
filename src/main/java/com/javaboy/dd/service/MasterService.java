package com.javaboy.dd.service;

import com.javaboy.dd.annotation.DataSource;
import com.javaboy.dd.mapper.MasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 20:36
 */
@Service
public class MasterService {
    @Autowired
    MasterMapper masterMapper;

    @DataSource("master")
    public void updateUserAge(String username, Integer age) {
        masterMapper.updateUserAge(username, age);
    }

}
