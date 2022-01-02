package com.ioc.service;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Service("CustomRequestService")
public class CustomRequestServiceImpl implements CustomRequestService {
    @Override
    public @Future Calendar submitRequest(
            @NotBlank String type,
            @Size(min = 20, max = 100) String description,
            @Past Calendar accountOpeningDate) {

        Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.MONTH,-1);
        cal.add(Calendar.MINUTE,1);
        return cal;
    }
}
