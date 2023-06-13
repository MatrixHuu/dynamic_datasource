package com.javaboy.dd.controller;

import com.javaboy.dd.datasource.DataSourceType;
import com.javaboy.dd.model.User;
import com.javaboy.dd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/13 20:04
 */

@RestController
public class DataSourceController {

    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(DataSourceController.class);

    @PostMapping("/dstype")
    public void setDsType(String dsType, HttpSession session) {
        session.setAttribute(DataSourceType.DS_SESSION_KEY, dsType);
        logger.info("数据源切换为： {}", dsType);
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
