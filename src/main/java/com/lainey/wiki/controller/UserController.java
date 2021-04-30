package com.lainey.wiki.controller;

import com.alibaba.fastjson.JSONObject;
import com.lainey.wiki.req.UserLoginReq;
import com.lainey.wiki.req.UserQueryReq;
import com.lainey.wiki.req.UserResetPasswordReq;
import com.lainey.wiki.req.UserSaveReq;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.resp.UserLoginResp;
import com.lainey.wiki.resp.UserQueryResp;
import com.lainey.wiki.service.UserService;
import com.lainey.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/user")

public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

    @GetMapping("/list")//接口
    public CommonResp list(@Valid UserQueryReq req){
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>();
        PageResp<UserQueryResp> list =userService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes())); //让密码加密 通过这句变成32位的16进制的字符串
        CommonResp resp = new CommonResp<>();
        userService.save(req);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp resp = new CommonResp<>();
        userService.delete(id);
        return resp;
    }

    @PostMapping("/reset-password")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes())); //让密码加密 通过这句变成32位的16进制的字符串
        CommonResp resp = new CommonResp<>();
        userService.ResetPassword(req);
        return resp;
    }

    @PostMapping("/login")
    public CommonResp login(@Valid @RequestBody UserLoginReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes())); // 注册的时候（添加用户的时候，密码是经过两层加密的，登陆的时候也应该经过两层加密 这样才能将两层加密后的密文跟数据库进行对比 进行校验）
        CommonResp<UserLoginResp> resp = new CommonResp<>();
        UserLoginResp userLoginResp = userService.login(req);

        Long token = snowFlake.nextId();// 生成token
        LOG.info("生成单点登录token:{}，并放入redis中",token);
        userLoginResp.setToken(token.toString());
        redisTemplate.opsForValue().set(token,  JSONObject.toJSONString(userLoginResp), 3600 * 24, TimeUnit.SECONDS);


        resp.setContent(userLoginResp);
        return resp;
    }

}
