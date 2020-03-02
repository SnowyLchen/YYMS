package com.ct.service.Impl;

import com.ct.mapper.SuperAdminMapper;
import com.ct.pojo.SuperAdmin;
import com.ct.service.SuperAdminService;
import com.ct.utils.login_out.Loginfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    private SuperAdminMapper superAdminMapper;

    @Override
    public int querySuperAdminCount() {
        try {
            int sam=superAdminMapper.queryAdminCount();
            return sam;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public boolean addSuperAdmin(SuperAdmin superAdmin) {
        try {
            int row=superAdminMapper.addSuperAdmin(superAdmin);
            if (row==0){
                return false;
            }else
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public SuperAdmin login(SuperAdmin superAdmin, HttpSession session) {
//        System.out.println("superAdminName:" + superAdmin.getName());
//        System.out.println("superAdminPwd:" + superAdmin.getPassword());
        if (superAdmin.getSuperName()!= null && superAdmin.getSuperPassword() != null&&!"".equals(superAdmin.getSuperPassword())&&!"".equals(superAdmin.getSuperName())) {
           try{
               List<SuperAdmin> superAdminlist = superAdminMapper.queryAdminByName(superAdmin);
//            System.out.println("-------------superadminList:" + superAdminlist);
               //查询超级管理员不等于null  list集合大小为1
               if (superAdminlist != null && superAdminlist.size() == 1) {
//            System.out.println(superAdminlist.get(0).getPassword().trim().equals(superAdmin.getPassword().trim())?"相等":"不对");
                   if (superAdminlist.get(0).getSuperPassword().equals(superAdmin.getSuperPassword())) {
//                       System.out.println(superAdminlist.get(0));
                       return superAdminlist.get(0);
                   }else {
                       System.out.println("用户名或密码错误");
                       Loginfo.LOGINERROR_MSG(session,"用户名或密码错误");
                       return null;
                   }
               }else {
                   System.out.println("用户名不存在");
                   Loginfo.LOGINERROR_MSG(session,"用户名不存在");
                   return null;
               }
           }catch (Exception e){
               e.printStackTrace();
               System.out.println("用户名或密码错误");
               Loginfo.LOGINERROR_MSG(session,"用户名或密码错误");
               return null;
           }
        } else {
            System.out.println("用户名或密码为空");
            Loginfo.LOGINERROR_MSG(session,"用户名或密码为空");
            return null;
        }

    }

    @Override
    public SuperAdmin queryAdminById(String id) {
        return superAdminMapper.queryAdminById(id);
    }

}
