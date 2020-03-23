package com.ct.utils.Validators;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckForm {

    /**
     * 检验表单提交是否有错误
     */

    public static boolean checkErrors(BindingResult result, HttpSession session)  {
        if (result.hasErrors()){
            Map<String,Object> map=new HashMap<>();
            List<FieldError> errorList = result.getFieldErrors();
            for (FieldError fieldError : errorList) {
                System.out.println("field:" + fieldError.getField() + ";errors:" + fieldError.getDefaultMessage());
                map.put(fieldError.getField() ,fieldError.getDefaultMessage());
            }
                session.setAttribute("FormErrorMap", map);

            return false;
        }else {
          return true;
        }

    }
}
