package com.lainey.wiki.controller;

import com.lainey.wiki.domain.Test;
import com.lainey.wiki.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Value("${test.hello:TEST}")
    private String testHello;

    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate redisTemplate;
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

    @GetMapping("/test/list")//接口
    public List<Test> list(){

        return testService.list();
    }
    @RequestMapping("/redis/set/{key}/{value}")
    public String set(@PathVariable Long key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value, 3600, TimeUnit.SECONDS);
        LOG.info("key: {}, value: {}", key, value);
        return "success";
    }

    @RequestMapping("/redis/get/{key}")
    public Object get(@PathVariable Long key) {
        Object object = redisTemplate.opsForValue().get(key); // 不知道具体的类型 统一用Object来接收
        LOG.info("key: {}, value: {}", key, object);
        return object;
    }

}
