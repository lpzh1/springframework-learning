package com.ioc.service;

import com.ioc.dao.DemoDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

//@Component("demoService")
@Setter
@Getter
public class DemoService {
    private DemoDao demoDao;

}
