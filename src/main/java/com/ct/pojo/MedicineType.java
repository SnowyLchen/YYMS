package com.ct.pojo;

public class MedicineType {
    private Integer mtId;
    private Integer mt2Id;
    private String mtFirType;
    private String mtSecType;

    public Integer getMtId() {
        return mtId;
    }

    public Integer getMt2Id() {
        return mt2Id;
    }

    public void setMt2Id(Integer mt2Id) {
        this.mt2Id = mt2Id;
    }

    public void setMtId(Integer mtId) {
        this.mtId = mtId;
    }

    public String getMtFirType() {
        return mtFirType;
    }

    public void setMtFirType(String mtFirType) {
        this.mtFirType = mtFirType;
    }

    public String getMtSecType() {
        return mtSecType;
    }

    public void setMtSecType(String mtSecType) {
        this.mtSecType = mtSecType;
    }

    public String getFirToJSON(){
        return  "\"mtId\":" + "\""+mtId +"\""+

                ", \"mtType\":" + "\""+mtFirType +"\"";
    }
    public String getSecToJSON(){
        return
                "\"mtId\":" +"\""+ mt2Id +"\""+
                ", \"mtType\":" +"\""+ mtSecType +"\"" ;
    }

    @Override
    public String toString() {
        return "MedicineType{" +
                "mtId=" + mtId +
                ", mtFirType='" + mtFirType + '\'' +
                ", mtSecType='" + mtSecType + '\'' +
                '}';
    }
}
