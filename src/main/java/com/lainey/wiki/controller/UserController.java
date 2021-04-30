package com.lainey.wiki.controller;

import com.lainey.wiki.req.UserQueryReq;
import com.lainey.wiki.req.UserSaveReq;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.resp.UserQueryResp;
import com.lainey.wiki.service.UserService;
import com.lainey.wiki.util.SnowFlake;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/user")

public class UserController {


    @Resource
    private UserService userService;

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
    
}
