package com.ct.controller.back;

import com.ct.mapper.MedicineMapper;
import com.ct.pojo.*;
import com.ct.service.DrugService;
import com.ct.utils.Validators.Boolean_NULL;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/Drugs")
public class DrugsController {
    private static String TRUE_STR="{\"result\":true}";
    private static String FALSE_STR="{\"result\":false}";

    private static String PREFIX="{\"data\":{";
    private static String TRUE_SUFFIX="},\"mata\":{\"msg\":\"获取成功\",\"status\":200}}";
    private static String ERR_SUFFIX="},\"mata\":{\"msg\":\"获取失败\",\"status\":500}}";


    @Autowired
    DrugService drugService;

    /**
     * 药品添加
     * @param medicine
     * @return
     */
    @RequestMapping("/addDrugs")
    public String addDrugs(Medicine medicine, Address address, Supplier supplier, MedicineType medicineType, HttpServletRequest request){
        MultipartFile mp_pic=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            mp_pic = multipartRequest.getFile("mp_pic");
        }
//        MedicinePic mp=new MedicinePic();
//        mp.setMpPic(mp_pic);
        medicine.setSupplier(supplier);
        medicine.setMedicineType(medicineType);
        if(medicine!=null){
            boolean add=drugService.addDrugs(medicine,address);
            if (add){
                return TRUE_STR;
            }else return FALSE_STR;
        }else return FALSE_STR;

    }

    /**
     * 查询所有药品
     */
    @RequestMapping("/queryAllDrugs")
    public String queryAllDrugs(String pagenum,String pagesize){
        if (Boolean_NULL.CHECK_NULL(pagenum)&&Boolean_NULL.CHECK_NULL(pagesize)){
            String Drugs=drugService.queryAllDrugs(Integer.parseInt(pagesize),Integer.parseInt(pagenum));
            Drugs=Drugs+TRUE_SUFFIX;
            return Drugs;
        }else {
            return PREFIX+ERR_SUFFIX;
        }
    }

    /**
     * 查询所有药品分类
     */
    @RequestMapping("/queryType")
    public String queryType(){
//        drugService.queryType()+TRUE_SUFFIX;
        return drugService.queryType()+TRUE_SUFFIX;
    }

    /**
     * 通过日期区间查询药品信息
     */


    /**
     * 添加商品分类
     */

    @RequestMapping("/addType")
    public String addType(MedicineType medicineType){



        return null;
    }
}
