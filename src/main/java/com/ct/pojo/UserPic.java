package com.ct.pojo;

import java.io.Serializable;

public class UserPic implements Serializable {
    private Integer uipId;

    private Integer uId;

    private String userPic;

    private static final long serialVersionUID = 1L;

    public Integer getUipId() {
        return uipId;
    }

    public void setUipId(Integer uipId) {
        this.uipId = uipId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }

    @Override
    public String toString() {
        return "UserPic{" +
                "uipId=" + uipId +
                ", uId=" + uId +
                ", userPic='" + userPic + '\'' +
                '}';
    }
}
