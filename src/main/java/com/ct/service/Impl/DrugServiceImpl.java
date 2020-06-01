package com.ct.service.Impl;

import com.ct.mapper.*;
import com.ct.pojo.*;
import com.ct.service.DrugService;
import com.ct.utils.Convert.convertJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    MedicineMapper medicineMapper;
    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private MedicinePicMapper medicinePicMapper;

    @Autowired
    private out_repositoryMapper outRepositoryMapper;

    @Override
    public boolean addDrugs(Medicine medicine, Address address) {
        try {
            //添加供应商地址,并返回地址id
            int add=addressMapper.INSAddress(address);
            if (add==0){
                System.out.println("供应商地址添加失败");
                return false;
            }
            //添加供应商，并返回其suId
            Supplier supplier=medicine.getSupplier();
            supplier.setAddId(address.getAddId());
            int su=supplierMapper.addSupplier(supplier);
            if (su==0){
                System.out.println("供应商添加失败");
                return false;
            }
            medicine.setSupplier(supplier);
            int row=medicineMapper.addDrugs(medicine);
            MedicinePic medicinePic=medicine.getMedicinePic();
            medicinePic.setMiId(medicine.getMiId());
            int pic=medicinePicMapper.insMp_pic(medicinePic);
            if (row==0||pic==0){
                return false;
            }else
                return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("添加药品出错");
            return false;
        }
    }

    @Override
    public String queryAllDrugs(int pagesize, int pagenum) {
        List<Medicine> drugs=null;
        try{
            Integer offset=(pagenum-1)*pagesize;
            drugs=medicineMapper.queryAllDrugs(offset,pagesize);
            System.out.println(drugs);
            int count=medicineMapper.queryAllDrugsCount();
            String drug= convertJSON.ConvertDrugs(count,drugs);
            System.out.println(drug);
            return drug;
        }catch (Exception e){
            e.printStackTrace();
            String drug= convertJSON.ConvertDrugs(0,drugs);
            return drug;
        }
    }

    @Override
    public String queryDrug(String name) {
        List<Medicine> drugs=null;
        try{
           Medicine medicine= medicineMapper.queryDrug(name);
           drugs.add(medicine);
           int count=1;
           String drug=convertJSON.ConvertDrugs(count,drugs);
           return drug;
        }catch (Exception e){
            e.printStackTrace();
            String drug= convertJSON.ConvertDrugs(0,drugs);
            return drug;
        }
    }

    @Override
    public String queryType() {
        try{
            List<MedicineType> mt =new ArrayList<>();
           //查询所有分类
            List<Medicine> mt2 =medicineMapper.queryType();
            for (int i=0;i<mt2.size();i++){
//                System.out.println(mt2.get(i).getMt2Id());
                mt.add(mt2.get(i).getMedicineType());
            }

            String drug= convertJSON.ConvertDrugsType(mt);
            System.out.println(drug);
            return drug;
        }catch (Exception e){
            e.printStackTrace();
//            String drug= convertJSON.ConvertDrugs(0,drugs);
//            return drug;
            return null;
        }
    }

    @Override
    public boolean addType(MedicineType medicineType) {
        try{
            int row=medicineMapper.addType(medicineType);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDrug(int miId) {
        try{
            int row=medicineMapper.deleteDrug(miId);
            if (row==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean inReposi(int msStock,int miId) {
        try{
            MedicineStock ms=new MedicineStock();
            ms.setMsStock(msStock);
            int row=medicineMapper.inReposi(ms);
            Integer msId=ms.getMsId();
            int up=medicineMapper.UpdateinReposi(miId,msId);
            if (row==0||up==0){
                return false;
            }else return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String queryAllInfo(int pagesize, int pagenum) {
            List<outRepository> or=null;
        try{
            Integer offset=(pagenum-1)*pagesize;
            or=outRepositoryMapper.queryAll(offset,pagesize);
            String str=convertJSON.ConvertInfo(10,or);
            return str;
        }catch (Exception e){
            e.printStackTrace();
            String str=convertJSON.ConvertInfo(0,or);
            return str;
        }
    }
    @Override
    public String queryBetweenTime(String start, String end) {
            List<outRepository> or=null;
        try{
            or=outRepositoryMapper.queryBetweenTime(start,end);
            String str=convertJSON.ConvertInfo(10,or);
            return str;
        }catch (Exception e){
            e.printStackTrace();
            String str=convertJSON.ConvertInfo(0,or);
            return str;
        }
    }
    @Override
    public String queryByName(String name,String queryData) {
            List<outRepository> or=null;
            List<Medicine> drugs=null;
            String str="";
        try{
            if (queryData.equals("medicine")) {
                drugs = medicineMapper.queryByName(name);
                str = convertJSON.ConvertDrugs(10, drugs);
            }
            if (queryData.equals("mInfo")){
                or=outRepositoryMapper.queryByName(name);
                str=convertJSON.ConvertInfo(10,or);
            }
            return str;
        }catch (Exception e){
            e.printStackTrace();
            str=convertJSON.ConvertInfo(0,or);
            return str;
        }
    }
}
