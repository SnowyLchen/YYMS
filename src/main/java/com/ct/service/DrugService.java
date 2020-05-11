package com.ct.service;

import com.ct.pojo.Medicine;
import com.ct.pojo.User;
import com.ct.pojo.UserPic;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

/**
 * 其他用户
 */
public interface DrugService {

    /**
     * 药品添加
     */
    boolean addDrugs(Medicine medicine);

    /**
     * 查询所有药品
     * @param parseInt
     * @param parseInt1
     * @return
     */

    String queryAllDrugs(@Param("offset") int offset, @Param("pagesize") int pageSize);

    /**
     * 按商品名查询
     */
    String queryDrug(String name);
    
}
