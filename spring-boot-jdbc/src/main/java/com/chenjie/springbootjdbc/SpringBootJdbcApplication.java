package com.chenjie.springbootjdbc;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

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

        application.setBanner((environment,sourceClass,out)->{
            System.out.println("      _      _       _\n" +                       "     | |    (_)     | |\n" +                       " ____| |__   _  ___ | |__    ___  _ __    __ _\n" +                       "|_  /| '_ \\ | |/ __|| '_ \\  / _ \\| '_ \\  / _` |\n" +                       " / / | | | || |\\__ \\| | | ||  __/| | | || (_| |\n" +                       "/___||_| |_||_||___/|_| |_| \\___||_| |_| \\__, |\n" +                       "                                          __/ |\n" +                       "                                         |___/\n");
        });

        application.setBannerMode(Banner.Mode.CONSOLE);

        application.run(args);
    }
}
