package com.ioc.validator;

import com.ioc.domain.FixedDepositDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FixedDepositValidator implements Validator {

    // 表示支持哪些校验对象类型
    @Override
    public boolean supports(Class<?> clazz) {
        return FixedDepositDetails.class.isAssignableFrom(clazz);
    }
    // 只有 supports 方法返回true，才会调用 validate 方法
    // 校验逻辑
    @Override
    public void validate(Object target, Errors errors) {
        FixedDepositDetails fixedDepositDetails = (FixedDepositDetails) target;
        if (fixedDepositDetails.getDepositAmount()==0){
            errors.reject("zeroDepositAmount");
        }
    }
}
