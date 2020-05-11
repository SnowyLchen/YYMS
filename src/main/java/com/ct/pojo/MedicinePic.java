package com.ct.pojo;

import java.io.Serializable;

public class MedicinePic implements Serializable {
    private Integer mpId;

    private Integer miId;

    private String mpPic;

    private static final long serialVersionUID = 1L;

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public Integer getMiId() {
        return miId;
    }

    public void setMiId(Integer miId) {
        this.miId = miId;
    }

    public String getMpPic() {
        return mpPic;
    }

    public void setMpPic(String mpPic) {
        this.mpPic = mpPic == null ? null : mpPic.trim();
    }
}