package com.javaboy.dd.mapper;

import com.javaboy.dd.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/12 20:03
 */

@Mapper
public interface UserMapper {

    @Select("Select * from user")
    List<User> getAllUsers();
}
