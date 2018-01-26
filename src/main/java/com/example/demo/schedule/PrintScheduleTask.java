package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务部分代码
 *
 * @author 高跃斌
 * @create 2017-10-23 11:34
 **/
@Configuration
@EnableScheduling
@Slf4j
public class PrintScheduleTask {

    //@Scheduled(cron = "0/5 * * * * ?")
    public void logMethod(){
        log.info("定时器测试任务！");
    }
}
