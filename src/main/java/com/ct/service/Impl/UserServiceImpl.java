package com.ct.service.Impl;

import com.ct.mapper.UserMapper;
import com.ct.pojo.User;
import com.ct.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 其他用户
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean UserRegister(User user) {
        try{
            int row=userMapper.UserRegister(user);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UserLogin(String Username, String Password,String identify) {
        try{
            User user=userMapper.UserLogin(Username,Password,identify);
            if (user!=null){
                return true;
            }else return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UserUpdate(User user) {
        try{
            boolean row=userMapper.UserUpdate(user);
            if (row){
                System.out.println("修改成功");
                return true;
            }else {
                System.out.println("修改失败");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("修改出错");
            return false;
        }
    }

    @Override
    public User seeInfo(String uId) {
        try{
            User user = userMapper.seeInfo(uId);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
