package com.lainey.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
public class TestController {

    @Value("${test.hello:TEST}")
    private String testHello;
    /*
    GET,POST,PUT,DELETE
    /USER/1
    @RETURN
     */
    //@PostMapping
    //PutMapping
    //DeleteMapping
    //@requestMapping(value="/user/1,method=RequestMethod.GET)
    //@requestMapping(value="/user/1,method=RequestMethod.DELETE)

    //http://127.0.0.1:8880/hello
    @GetMapping("/hello")//接口
    public String hello(){
        return "Hello World!"+testHello;
    }
    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "Hello World! Post,"+ name;
    }

}
