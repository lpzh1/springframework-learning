package com.ioc;

import com.ioc.service.CustomRequestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolationException;
import java.util.Calendar;

public class Jsr349Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //FixedDepositService service = context.getBean(FixedDepositService.class);
        //FixedDepositDetails details = new FixedDepositDetails();
        ////details.setId(1L);
        //details.setDepositAmount(10);
        //details.setEmail("xxx@");
        //details.setTenure(5);
        //service.createFixedDepositDetails(details);

        CustomRequestService service = context.getBean(CustomRequestService.class);
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MINUTE, 1);
        try {
            service.submitRequest("request type", "description size>20", date);
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

    }
}
