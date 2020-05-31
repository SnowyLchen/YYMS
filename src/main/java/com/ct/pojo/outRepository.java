package com.ct.pojo;

import java.io.Serializable;

public class outRepository implements Serializable {
    private Integer orId;

    private User user;

    private Medicine medicine;

    private String orTime;

    private Double orPince;

    private MedicinePic medicinePic;

    public MedicinePic getMedicinePic() {
        return medicinePic;
    }

    public void setMedicinePic(MedicinePic medicinePic) {
        this.medicinePic = medicinePic;
    }

    private static final long serialVersionUID = 1L;

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getOrTime() {
        return orTime;
    }

    public void setOrTime(String orTime) {
        this.orTime = orTime == null ? null : orTime.trim();
    }

    public Double getOrPince() {
        return orPince;
    }

    public void setOrPince(Double orPince) {
        this.orPince = orPince;
    }

    public String ToJson() {
        return
                "\"" + "orId" + "\":" + "\"" + orId + "\"," +
                        "\"" + "orTime" + "\":" + "\"" + orTime + "\"," +
                        "\"" + "orPince" + "\":" + "\"" + orPince + "\"," +
                        "\"" + "mName" + "\":" + "\"" + medicine.getMiName() + "\"," +
                        "\"" + "mNumber" + "\":" + "\"" + medicine.getMiNumber() + "\"," +
                        "\"" + "mStandard" + "\":" + "\"" + medicine.getMiStandard() + "\"," +
                        "\"" + "mAmount" + "\":" + "\"" + medicine.getMiAmount() + "\"," +
                        "\"" + "mPrice" + "\":" + "\"" + medicine.getMiPrince() + "\"," +
                        "\"" + "mPic" + "\":" + "\"" + medicinePic.getMpPic() + "\"," +
                        "\"" + "userName" + "\":" + "\"" + user.getuUsername() + "\""
                ;
    }
}