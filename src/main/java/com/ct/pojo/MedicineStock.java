package com.ct.pojo;

import java.io.Serializable;

public class MedicineStock implements Serializable {
    private Integer msId;

    private Integer miId;

    private Integer msStock;

    private Integer msSales;

    private static final long serialVersionUID = 1L;

    public Integer getMsId() {
        return msId;
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public Integer getMiId() {
        return miId;
    }

    public void setMiId(Integer miId) {
        this.miId = miId;
    }

    public Integer getMsStock() {
        return msStock;
    }

    public void setMsStock(Integer msStock) {
        this.msStock = msStock;
    }

    public Integer getMsSales() {
        return msSales;
    }

    public void setMsSales(Integer msSales) {
        this.msSales = msSales;
    }
}