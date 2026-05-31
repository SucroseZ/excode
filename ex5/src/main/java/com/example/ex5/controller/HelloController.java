package com.example.ex5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//通过RestController注解，向Springboot说明这是一个响应网络请求的类。
@RestController
public class HelloController {
//    通过GetMapping注解，向SpringBoot说明可以相应/hello的Get请求
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
