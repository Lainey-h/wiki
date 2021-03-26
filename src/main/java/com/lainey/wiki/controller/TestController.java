package com.lainey.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
public class TestController {
    //http://127.0.0.1:8880/hello
    @RequestMapping("/hello")//接口
    public String hello(){
        return "Hello World";
    }
}
