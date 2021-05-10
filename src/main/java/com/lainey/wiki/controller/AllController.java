package com.lainey.wiki.controller;

import com.lainey.wiki.domain.All;
import com.lainey.wiki.req.AllQueryReq;
import com.lainey.wiki.req.AllSaveReq;
import com.lainey.wiki.resp.AllQueryResp;
import com.lainey.wiki.resp.CommonResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.service.AllService;
import com.lainey.wiki.service.FszzService;
import com.lainey.wiki.service.JsjgService;
import com.lainey.wiki.service.MainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController// RestContraller用来返回字符串
//@Controller//用来返回页面 表示访问地址("/hello")的时候要返回一个页面
@RequestMapping("/all")

public class AllController {


    @Resource
    private JsjgService jsjgService;
    @Resource
    private MainService mainService;
    @Resource
    private FszzService fszzService;
    @Resource
    AllService allService;

    @GetMapping("/list")//接口 这个是干撒的，昨天写的？ 这些 好多是我拷贝来改的 我看到左右的实体类的增删改查接口都写得差不多 我封装完All的参数以后就照猫画虎  都是 list查询 save更新 delete删除
    public CommonResp list(@Valid AllQueryReq req){
        CommonResp<PageResp<AllQueryResp>> resp = new CommonResp<>();
        PageResp<AllQueryResp> list = allService.list(req); // 这个是你封装的吧 嗯嗯
        resp.setContent(list);
        return resp;
    }
//参数类型不对这个不用
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody AllSaveReq req){
        CommonResp resp = new CommonResp<>();
        allService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{albh}")
    public CommonResp delete(@PathVariable Long albh){
        CommonResp resp = new CommonResp<>();
        allService.delete(albh);
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
    @PostMapping("/update/{albh}")
    public Integer update(@PathVariable Long albh, @RequestBody All all){
        //all是你要改的对象信息
        //斜杠方法处理更新逻辑
        jsjgService.update(all);
        return 0;
    }
}
