package com.ct.service.Impl;

import com.ct.mapper.AuthorityMapper;
import com.ct.mapper.SuperAdminMapper;
import com.ct.pojo.SuperAdmin;
import com.ct.service.AuthorityService;
import com.ct.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;


    @Override
    public int queryIdByRole(String role) {
        try{
            int id=authorityMapper.queryIdByRole(role);
            System.out.println("id="+id);
            if (id==0){
                return 0;
            }else return id;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String queryRoleById(Integer aId) {
        try{
            String role=authorityMapper.queryRoleById(aId);
            System.out.println("role="+role);
            if (role==null||role.equals("")){
                return null;
            }else return role;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
