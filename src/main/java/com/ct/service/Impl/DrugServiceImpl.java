package com.ct.service.Impl;

import com.ct.mapper.AddressMapper;
import com.ct.mapper.MedicineMapper;
import com.ct.mapper.MedicinePicMapper;
import com.ct.mapper.SupplierMapper;
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
}
