package com.ct.pojo;

import java.io.Serializable;

public class Supplier implements Serializable {
    private Integer suId;

    private String suName;

    private Integer suPhone;

    private Integer addId;

    private static final long serialVersionUID = 1L;

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getSuName() {
        return suName;
    }

    public void setSuName(String suName) {
        this.suName = suName == null ? null : suName.trim();
    }

    public Integer getSuPhone() {
        return suPhone;
    }

    public void setSuPhone(Integer suPhone) {
        this.suPhone = suPhone;
    }

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }
}