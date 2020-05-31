package com.ct.mapper;

import com.ct.pojo.Staff_Info;
import com.ct.pojo.User;
import com.ct.pojo.UserPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取identify
     * @param uId
     * @return
     */
    String Check_IDENTIFY(@Param("uId") Integer uId);

    /**
     * 获取用户列表
     * @param offset
     * @param pagesize
     * @return
     */
    List<User> AllUsers(@Param("offset") Integer offset,@Param("pagesize") Integer pagesize);

    /**
     * 查询用户数量
     * @return
     */
    int queryAllUsersCount();

    /**
     * 删除用户
     * @param uId
     * @return
     */
    int delete(@Param("uId") String uId);

    /**
     * 更新职位
     * @param staff_info
     * @return
     */
    boolean updatePosition(Staff_Info staff_info,@Param("uId") Integer uId);

    /**
     * 通过id模糊查询
     * @param identify
     * @return
     */
    List<User> queryById(@Param("identify") String identify);
}