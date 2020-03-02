package com.ct.pojo;

import java.io.Serializable;

public class Authority implements Serializable {
    //角色对应的id
    private Integer aId;
    //角色名
    private String aRole;

    private static final long serialVersionUID = 1L;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaRole() {
        return aRole;
    }

    public void setaRole(String aRole) {
        this.aRole = aRole == null ? null : aRole.trim();
    }
}