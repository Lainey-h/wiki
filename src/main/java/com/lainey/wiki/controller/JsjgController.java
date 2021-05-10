package com.lainey.wiki.controller;

import com.lainey.wiki.req.JsjgQueryReq;
import com.lainey.wiki.req.JsjgSaveReq;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.JsjgQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.service.JsjgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/jsjgs")

public class JsjgController {


    @Resource
    private JsjgService jsjgService;


    @GetMapping("/list")//接口
    public CommonResp list(@Valid JsjgQueryReq req){
        CommonResp<PageResp<JsjgQueryResp>> resp = new CommonResp<>();
        PageResp<JsjgQueryResp> list =jsjgService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody JsjgSaveReq req){
        CommonResp resp = new CommonResp<>();
        jsjgService.save(req);
        return resp;
    }
//    @DeleteMapping("/delete/{albh}")
//    public CommonResp delete(@PathVariable Long albh){
//        CommonResp resp = new CommonResp<>();
//        jsjgService.delete(albh);
//        return resp;
//    }
}
