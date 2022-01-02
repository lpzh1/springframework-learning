package com.ioc.service;

import com.ioc.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.Iterator;
import java.util.Set;

@Service("fixedDepositService")
public class FixedDepositService {

    @Autowired
    private Validator validate;

    // 使用spring框架的验证接口
    //public void createFixedDepositDetails(FixedDepositDetails details){
    //    // 构造一个 BeanPropertyBindingResult 对象
    //    BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(details, "Error");
    //    // 创建一个验证器
    //    //FixedDepositValidator validator = new FixedDepositValidator();
    //    validate.validate(details,bindingResult);
    //
    //    if (bindingResult.getErrorCount()>0){
    //        System.out.println(" 验证出错 ");
    //        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    //        List<ObjectError> allErrors = bindingResult.getAllErrors();
    //        Object target = bindingResult.getTarget();
    //        List<FieldError> depositAmountError = bindingResult.getFieldErrors("depositAmount");
    //
    //        //System.out.println(allErrors);
    //        //System.out.println(fieldErrors);
    //        //System.out.println(target);
    //        //System.out.println(depositAmountError);
    //        for (FieldError fieldError : fieldErrors) {
    //            //System.out.println(fieldError);
    //            System.out.println(fieldError.getField()+"==="+fieldError.getDefaultMessage()+"---"+fieldError.getRejectedValue());
    //        }
    //        //for (ObjectError objError : allErrors) {
    //        //    System.out.println(objError);
    //        //}
    //
    //    }else{
    //        System.out.println(" 验证通过 ");
    //    }
    //
    //}

    // 使用 jsr349的 Validator 和 ValidatorFactory 接口
    public void createFixedDepositDetails(FixedDepositDetails details) {
        Set<ConstraintViolation<FixedDepositDetails>> violations = this.validate.validate(details);
        Iterator<ConstraintViolation<FixedDepositDetails>> iterator = violations.iterator();
        while(iterator.hasNext()) {
            ConstraintViolation<FixedDepositDetails> next = iterator.next();
            ConstraintDescriptor<?> descriptor = next.getConstraintDescriptor();
            Object invalidValue = next.getInvalidValue();
            Object leafBean = next.getLeafBean();
            String message = next.getMessage();
            Object[] parameters = next.getExecutableParameters();
            Path propertyPath = next.getPropertyPath();
            Class<FixedDepositDetails> rootBeanClass = next.getRootBeanClass();
            FixedDepositDetails rootBean = next.getRootBean();

            System.out.println("----------------下一个---------------");
            //System.out.println(descriptor);
            System.out.println("invalidValue: " + invalidValue);
            System.out.println("leafBean: " + leafBean);
            System.out.println("message: " + message);
            System.out.println("parameters: " + parameters);
            System.out.println("propertyPath: "+propertyPath);
            System.out.println("rootBeanClass: " + rootBeanClass.getName());
            System.out.println("rootBean: " + rootBean);
        }

        System.out.println("错误数量: "+violations.size());
        if (violations.size()<=0){
            System.out.println("验证通过，没有错误");
        }
    }

}
