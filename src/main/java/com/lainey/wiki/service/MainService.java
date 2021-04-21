package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.Main;
import com.lainey.wiki.domain.MainExample;
import com.lainey.wiki.mapper.MainMapper;
import com.lainey.wiki.req.MainReq;
import com.lainey.wiki.resp.MainResp;
import com.lainey.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainService {

    private static final Logger LOG = LoggerFactory.getLogger(MainService.class);

    @Resource
    private MainMapper mainMapper;

    public List<MainResp> list(MainReq req){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getAlbh())){
            criteria.andAlbhEqualTo(req.getAlbh());
        }

        PageHelper.startPage(1,8);
        List<Main> mainList = mainMapper.selectByExample(mainExample);

        PageInfo<Main> pageInfo = new PageInfo<>(mainList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

      /*  List<MainResp> respList = new ArrayList<>();
        for (Main main : mainList) {
            MainResp mainResp = new MainResp();
            BeanUtils.copyProperties(main,mainResp);
            // mainResp.setBz("备注"); 该句是用来测试是否生效的
            respList.add(mainResp);
        }*/

        List<MainResp> list = CopyUtil.copyList(mainList, MainResp.class);
        return list;
    }
}
