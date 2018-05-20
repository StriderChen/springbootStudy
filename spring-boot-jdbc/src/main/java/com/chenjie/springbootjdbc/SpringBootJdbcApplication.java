package com.chenjie.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenjie
 */
@SpringBootApplication
public class SpringBootJdbcApplication {

    /*public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }*/
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootJdbcApplication.class);
        springApplication.run(args);
    }
}
