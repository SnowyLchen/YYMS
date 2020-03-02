package com.ct.controller.back;


import com.ct.pojo.Authority;
import com.ct.pojo.SuperAdmin;
import com.ct.service.AuthorityService;
import com.ct.service.SuperAdminService;
import com.ct.utils.login_out.Loginfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SuperAdmin")
public class SuperAdminController {

    //自动注入superadmin
    @Autowired
    private SuperAdminService superAdminService;
    //自动注入Authority
    @Autowired
    private AuthorityService authorityService;

    //初始化superadmin
    @ResponseBody
    @RequestMapping("/addsuperadmin")
    public String addSuperAdmin(SuperAdmin superAdmin, Authority authority, HttpSession session){
        if (superAdmin!=null&&authority!=null){
            superAdmin.setSuperRole(authority);
        }
//        System.out.println("-----"+authority);
//        System.out.println("====="+superAdmin);
        //获取superadmin表中的总数据记录数，大于1条时拒绝插入
        int row=superAdminService.querySuperAdminCount();
        if(row>0){

            Loginfo.REGISTER_INFO(session,"已存在超级管理员 无法初始化！");
//            return "redirect:/WEB-INF/jsp/error.jsp";
            return "0";
        }else{
            //查询角色表中对应职位id
            int roleId=authorityService.queryIdByRole(authority.getaRole());
            if (roleId==0){
                return "0";
            }
            authority.setaId(roleId);
            boolean addAdmin=superAdminService.addSuperAdmin(superAdmin);
            if (addAdmin){
                return "1";
            }else return "0";
//            return "backManage/Loginfo/Loginfo";
        }
    }

    //superadmin登陆
    @RequestMapping("/login")
    public String login(SuperAdmin superAdmin, HttpSession session){

            if (superAdmin != null) {
                 superAdmin = superAdminService.login(superAdmin,session);
                 if (superAdmin==null){
                     return "redirect:/SuperAdmin/ToLogin";
                 }else {
                     //登录成功  跳向成功页面
                     session.setAttribute("SUPERADMIN_SESSION", superAdmin);
                     session.setAttribute("SUPERADMIN_ID", superAdmin.getSuperId());
                     //存储管理员开发者信息
                     String role=authorityService.queryRoleById(superAdmin.getSuperRole().getaId());
                     superAdmin.getSuperRole().setaRole(role);
                     Loginfo.USER_INFO(session,superAdmin);
                     return "redirect:/SuperAdmin/ToLogin";
                 }
            } else {
                //存储错误信息
                Loginfo.LOGINERROR_MSG(session,"请先登录");
                //登录失败  跳向登陆页面
                return "redirect:/SuperAdmin/ToLogin";
            }

    }

    @RequestMapping("/ToLogin")
    public String llo(HttpSession session){
        //先判断是否有管理员登陆
        Object o=session.getAttribute("SUPERADMIN_ID");
        if (o==null||o.equals("")){
            System.out.println("当前没有管理员登陆");
            //存储错误信息
            Loginfo.LOGINERROR_MSG(session,"请先登录");
            return "backManage/Loginfo/Loginfo";
        }else
        return "backManage/navigation/nav";
    }

    //superadmin退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("SUPERADMIN_ID");
        session.removeAttribute("SUPERADMIN_SESSION");
        session.invalidate();
        return "redirect:/SuperAdmin/ToLogin";
    }


}
