package com.ioc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskService {

    // 每隔5s执行一次
    @Scheduled(fixedRate = 5000)
    public void helle() {
        log.info("TaskService--->hello task ....");
    }
}
