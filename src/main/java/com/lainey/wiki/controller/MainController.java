package com.lainey.wiki.controller;

import com.lainey.wiki.domain.All;
import com.lainey.wiki.req.MainQueryReq;
import com.lainey.wiki.req.MainSaveReq;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.MainQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.service.MainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/main")

public class MainController {


    @Resource
    private MainService mainService;


    @GetMapping("/list")//接口 那个调的这个接口，
    public CommonResp list(@Valid MainQueryReq req){
        CommonResp<PageResp<MainQueryResp>> resp = new CommonResp<>();
        PageResp<MainQueryResp> list =mainService.list(req);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody MainSaveReq req){
        CommonResp resp = new CommonResp<>();
        mainService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{albh}")
    public CommonResp delete(@PathVariable Long albh){
        CommonResp resp = new CommonResp<>();
        mainService.delete(albh);
        return resp;
    }

    @GetMapping("/listByAlbh/{albh}")
    public List<All> listByAlbh(@PathVariable Long albh){
        All all = new All();
        all = mainService.listByAlbh(albh);
        List<All> list = new ArrayList<>();
        list.add(all);
        return list;
    }



}
