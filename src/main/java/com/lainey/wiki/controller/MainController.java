package com.lainey.wiki.controller;

import com.lainey.wiki.domain.Main;
import com.lainey.wiki.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/main")

public class MainController {


    @Resource
    private MainService mainService;


    @GetMapping("/list")//接口
    public List<Main> list(){

        return mainService.list();
    }

}
