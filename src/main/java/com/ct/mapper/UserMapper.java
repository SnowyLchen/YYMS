package com.ct.mapper;

import com.ct.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 用户的注册
     * @param user
     * @return
     */
    int UserRegister(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     */
    User UserLogin(@Param("username") String username, @Param("password") String password,@Param("identify") String identify);
}