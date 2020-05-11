package com.ct.service.Impl;

import com.ct.mapper.MedicineMapper;
import com.ct.pojo.Medicine;
import com.ct.pojo.User;
import com.ct.service.DrugService;
import com.ct.utils.Convert.convertJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    MedicineMapper medicineMapper;

    @Override
    public boolean addDrugs(Medicine medicine) {
        try {
            int row=medicineMapper.addDrugs(medicine);
            if (row==0){
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
}
