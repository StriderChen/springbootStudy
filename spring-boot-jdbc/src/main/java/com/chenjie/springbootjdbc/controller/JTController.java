package com.chenjie.springbootjdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjie
 * @date 2018/5/18 23:56
 * @description:
 */
@RestController
@RequestMapping("JT")
public class JTController {

    @GetMapping(value = "hello")
    public String hello(){
        return "HelloWorld!";
    }

}
