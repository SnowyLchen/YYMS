package com.ct.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer addId;

    private String addProvince;

    private String addCity;

    private String addInfo;

    private static final long serialVersionUID = 1L;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince == null ? null : addProvince.trim();
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity == null ? null : addCity.trim();
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo == null ? null : addInfo.trim();
    }
}