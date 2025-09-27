package com.ymcc.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Light xhh032533@163.com
 * @text Passion！无他,唯手熟尔！More Code & Thinking Why, 每一行代码但是你进步的基石！理解大于记忆
 * @time 2025/9/25 21:50
 */
//事务管理
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.ymcc.service.mapper")
public class ServiceUserApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApp.class,args);
    }
}
