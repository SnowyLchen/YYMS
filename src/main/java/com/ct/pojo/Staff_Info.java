package com.ct.pojo;

import java.io.Serializable;

public class Staff_Info implements Serializable {
    private Integer siId;

    private String siPosition;

    private Float siSalary;

    private static final long serialVersionUID = 1L;

    public Integer getSiId() {
        return siId;
    }

    public void setSiId(Integer siId) {
        this.siId = siId;
    }

    public String getSiPosition() {
        return siPosition;
    }

    public void setSiPosition(String siPosition) {
        this.siPosition = siPosition == null ? null : siPosition.trim();
    }

    public Float getSiSalary() {
        return siSalary;
    }

    public void setSiSalary(Float siSalary) {
        this.siSalary = siSalary;
    }

    @Override
    public String toString() {
        return "Staff_Info{" +
                "siId=" + siId +
                ", siPosition='" + siPosition + '\'' +
                ", siSalary=" + siSalary +
                '}';
    }
}