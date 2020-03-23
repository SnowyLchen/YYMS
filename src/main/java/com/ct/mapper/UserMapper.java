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

    /**
     * 用户修改
     * @param user
     * @return
     */
    boolean UserUpdate(User user);

    /**
     * 查询全部信息
     * @param uId
     * @return
     */
    User seeInfo(@Param("uId") String uId);
}