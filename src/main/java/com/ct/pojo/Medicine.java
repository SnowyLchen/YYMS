package com.ct.pojo;

import java.io.Serializable;

public class Medicine implements Serializable {
    private Integer miId;

    private Supplier suId;

    private String miNumber;

    private String miName;

    private Double miPrince;

    private Integer miAmount;

    private String miStandard;

    private MedicineType mt2Id;

    private MedicineStock medicineStock;

    private MedicinePic medicinePic;

    private static final long serialVersionUID = 1L;

    public Integer getMiId() {
        return miId;
    }

    public void setMiId(Integer miId) {
        this.miId = miId;
    }

    public String getMiNumber() {
        return miNumber;
    }

    public void setMiNumber(String miNumber) {
        this.miNumber = miNumber == null ? null : miNumber.trim();
    }

    public String getMiName() {
        return miName;
    }

    public void setMiName(String miName) {
        this.miName = miName == null ? null : miName.trim();
    }

    public Double getMiPrince() {
        return miPrince;
    }

    public void setMiPrince(Double miPrince) {
        this.miPrince = miPrince;
    }

    public Integer getMiAmount() {
        return miAmount;
    }

    public void setMiAmount(Integer miAmount) {
        this.miAmount = miAmount;
    }

    public String getMiStandard() {
        return miStandard;
    }

    public void setMiStandard(String miStandard) {
        this.miStandard = miStandard == null ? null : miStandard.trim();
    }

    public void setSuId(Supplier suId) {
        this.suId = suId;
    }

    public MedicineType getMt2Id() {
        return mt2Id;
    }

    public void setMt2Id(MedicineType mt2Id) {
        this.mt2Id = mt2Id;
    }

    public Supplier getSuId() {
        return suId;
    }

    public MedicineStock getMedicineStock() {
        return medicineStock;
    }

    public void setMedicineStock(MedicineStock medicineStock) {
        this.medicineStock = medicineStock;
    }

    public MedicinePic getMedicinePic() {
        return medicinePic;
    }

    public void setMedicinePic(MedicinePic medicinePic) {
        this.medicinePic = medicinePic;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "miId=" + miId +
                ", suId=" + suId +
                ", miNumber='" + miNumber + '\'' +
                ", miName='" + miName + '\'' +
                ", miPrince=" + miPrince +
                ", miAmount=" + miAmount +
                ", miStandard='" + miStandard + '\'' +
                ", mt2Id=" + mt2Id +
                ", medicineStock=" + medicineStock +
                ", medicinePic=" + medicinePic +
                '}';
    }

    public String ToJson() {
        return  "\""+"me_id"+"\":"+"\""+ miId +"\","+
                "\""+"me_batch"+"\":"+"\""+miNumber +"\","+
                "\""+"me_specs"+"\":"+"\""+miStandard +"\","+
                "\""+"me_stock"+"\":"+"\""+medicineStock.getMsStock() +"\","+
                "\""+"me_sale"+"\":"+"\""+medicineStock.getMsSales() +"\","+
                "\""+"me_name"+"\":"+"\""+miName +"\","+
                "\""+"me_pic"+"\":"+"\""+medicinePic.getMpPic() +"\","+
                "\""+"me_price"+"\":"+"\""+miPrince +"\","+
                "\""+"su_name"+"\":"+"\""+suId.getSuName() +"\","+
                "\""+"su_phone"+"\":"+"\""+suId.getSuPhone() +"\"";
    }
}