package com.lainey.wiki.controller;

import com.lainey.wiki.req.FszzQueryReq;
import com.lainey.wiki.req.FszzSaveReq;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.FszzQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.service.FszzService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/fszz")

public class FszzController {


    @Resource
    private FszzService fszzService;


    @GetMapping("/list")//接口
    public CommonResp list(@Valid FszzQueryReq req){
        CommonResp<PageResp<FszzQueryResp>> resp = new CommonResp<>();
        PageResp<FszzQueryResp> list =fszzService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody FszzSaveReq req){
        CommonResp resp = new CommonResp<>();
        fszzService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{albh}")
    public CommonResp delete(@PathVariable Long albh){
        CommonResp resp = new CommonResp<>();
        fszzService.delete(albh);
        return resp;
    }
}
