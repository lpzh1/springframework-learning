package com.ioc.service;

import com.ioc.domain.FixedDepositDetails;
import com.ioc.validator.FixedDepositValidator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service("fixedDepositService")
public class FixedDepositService {


    public void createFixedDepositDetails(FixedDepositDetails details){
        // 构造一个 BeanPropertyBindingResult 对象
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(details, "Error");
        // 创建一个验证器
        FixedDepositValidator validator = new FixedDepositValidator();
        validator.validate(details,bindingResult);

        if (bindingResult.getErrorCount()>0){
            System.out.println(" 验证出错 ");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            System.out.println(fieldErrors);
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField()+"----"+fieldError.getObjectName());
            }
        }else{
            System.out.println(" 验证通过 ");
        }

    }
}
