package com.ioc;


import com.ioc.domain.FixedDepositDetails;
import com.ioc.service.FixedDepositService;
import com.ioc.validator.FixedDepositValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

//@SpringBootApplication
public class ValidatorApplication {

    public static void main(String[] args) {
        // 要验证的bean
        FixedDepositDetails details = new FixedDepositDetails();
        //details.setDepositAmount(1.15F);

        // 构造一个 BeanPropertyBindingResult 对象
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(details, "detailsBindingResult");
        // 创建一个验证器
        FixedDepositValidator validator = new FixedDepositValidator();
        validator.validate(details,bindingResult);

        if (bindingResult.getErrorCount()>0){
            System.out.println(" 验证出错 ");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            Object target = bindingResult.getTarget();
            List<FieldError> depositAmountError = bindingResult.getFieldErrors("depositAmount");

            System.out.println(allErrors);
            System.out.println(fieldErrors);
            System.out.println(target);
            System.out.println(depositAmountError);

        }else{
            System.out.println(" 验证通过 ");
        }

    }

    //public static void main(String[] args) {
    //    ConfigurableApplicationContext run = SpringApplication.run(ValidatorApplication.class);
    //    FixedDepositService service = run.getBean(FixedDepositService.class);
    //
    //    FixedDepositDetails details = new FixedDepositDetails();
    //    //details.setDepositAmount(1.15F);
    //
    //    service.createFixedDepositDetails(details);
    //}
}
