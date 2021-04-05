package com.lainey.wiki.controller;

import com.lainey.wiki.domain.Demo;
import com.lainey.wiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/demo")

public class DemoController {


    @Resource
    private DemoService demoService;


    @GetMapping("/list")//接口
    public List<Demo> list(){

        return demoService.list();
    }

}
