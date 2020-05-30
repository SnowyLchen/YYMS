package com.ct.service.Impl;

import com.ct.mapper.Staff_InfoMapper;
import com.ct.mapper.UserMapper;
import com.ct.mapper.UserPicMapper;
import com.ct.pojo.Staff_Info;
import com.ct.pojo.User;
import com.ct.pojo.UserPic;
import com.ct.service.UserService;
import com.ct.utils.Convert.convertJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 其他用户
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPicMapper userPicMapper;
    @Autowired
    private Staff_InfoMapper staff_infoMapper;

    @Override
    public boolean UserRegister(User user) {
        try{
            int row=userMapper.UserRegister(user);
            UserPic up=new UserPic();
            up.setuId(user.getuId());
            String path="static/upload/images/UserPic/头像.jpg";
            up.setUserPic(path);
            userPicMapper.insert(up);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UserLogin(String Username, String Password, String identify, HttpSession session) {
        try{
            User user=userMapper.UserLogin(Username,Password,identify);
            if (user!=null){
                session.setAttribute("USER_ID",user.getuId());
                System.out.println("获取的id："+session.getAttribute("USER_ID"));
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
            System.out.println(user);
//            boolean posi=userMapper.updatePosition(user.getStaff_info(),user.getuId());
            if (row){
                System.out.println("User修改成功");
                return true;
            }else {
                System.out.println("User修改失败");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("User修改出错");
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

    @Override
    public String Check_IDENTIFY(Integer uId) {
        try{
            String identify=userMapper.Check_IDENTIFY(uId);
            return identify;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean alterHeadPic(UserPic userPic) {
        try{
            boolean row=userPicMapper.alterHeadPic(userPic);
            if (row){
                System.out.println("头像修改成功");
                return true;
            }else {
                System.out.println("头像修改失败");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("头像修改出错");
            return false;
        }
    }

    @Override
    public String AllUsers(Integer pagesize, Integer pagenum) {
        List<User> users=null;
        try{
            Integer offset=(pagenum-1)*pagesize;
            System.out.println(offset+"--"+pagesize);
            users=userMapper.AllUsers(offset,pagesize);
            int count=userMapper.queryAllUsersCount();
            String user= convertJSON.Convert(count,users);
            System.out.println(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            String user= convertJSON.Convert(0,users);
            return user;
        }
    }

    @Override
    public boolean delete(String uId) {
        try{
            int row=userMapper.delete(uId);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Staff_Info>  queryPosi() {
        List<Staff_Info> staff_infos=null;
        try{
            staff_infos=staff_infoMapper.queryPosi();
            return staff_infos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
