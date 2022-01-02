package com.ioc.service;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Validated
public interface CustomRequestService {

    //验证不通过，将抛出异常
    @Future // 方法返回值的Calendar对象必须是将来的日期
    Calendar submitRequest(@NotBlank String type,
                           @Size(min = 20,max = 100) String description,
                           @Past Calendar accountOpeningDate);

}
