package com.chenjie.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjie
 * @date 2018/6/3 0:07
 * @Description: springboot整合mybatis
 */
@SpringBootApplication
@MapperScan(basePackages = "com.chenjie.springbootmybatis.dao")
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
