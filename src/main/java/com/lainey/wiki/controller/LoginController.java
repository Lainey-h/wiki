package com.lainey.wiki.controller;

// import com.lainey.wiki.exception.BusinessException;

import com.lainey.wiki.req.MainQueryReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理、数据预处理等
 */
@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/main")
public class LoginController {

    @GetMapping("/login")//接口
    public Map login(@Valid MainQueryReq req){

        Map<String,Object> map = new HashMap<>();

        return map;
    }

}
