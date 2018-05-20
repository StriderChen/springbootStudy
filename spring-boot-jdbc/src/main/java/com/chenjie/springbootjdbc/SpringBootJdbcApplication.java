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
        SpringApplication application = new SpringApplication(SpringBootJdbcApplication.class);
        application.run(args);
    }
}
