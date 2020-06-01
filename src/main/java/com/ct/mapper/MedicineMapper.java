package com.ct.mapper;

import com.ct.pojo.Medicine;
import com.ct.pojo.MedicineStock;
import com.ct.pojo.MedicineType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicineMapper {

    int addDrugs(Medicine medicine);


    List<Medicine> queryAllDrugs(@Param("offset") Integer offset,@Param("pagesize") int pagesize);

    int queryAllDrugsCount();

    Medicine queryDrug(@Param("miName") String name);

    List<Medicine> queryType();

    int addType(MedicineType medicineType);

    int deleteDrug(@Param("miId") Integer miId);

    List<Medicine> queryByName(@Param("name") String name);

    int inReposi(MedicineStock stock);

    int UpdateinReposi(@Param("miId")int miId,@Param("msStock")Integer msId);
}