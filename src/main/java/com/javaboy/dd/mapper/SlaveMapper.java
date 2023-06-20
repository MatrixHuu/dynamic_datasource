package com.javaboy.dd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/20 20:37
 */
@Mapper
public interface SlaveMapper {

    @Update("update user set age = #{age}  where username = #{username};")
    int updateUserAge(@Param("username") String username, @Param("age") Integer age);
}
