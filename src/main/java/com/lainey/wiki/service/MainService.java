package com.lainey.wiki.service;

import com.lainey.wiki.domain.Main;
import com.lainey.wiki.domain.MainExample;
import com.lainey.wiki.mapper.MainMapper;
import com.lainey.wiki.req.MainReq;
import com.lainey.wiki.resp.MainResp;
import com.lainey.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainService {

    @Resource
    private MainMapper mainMapper;

    public List<MainResp> list(MainReq req){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getAlbh())){
            criteria.andAlbhEqualTo(req.getAlbh());
        }
        List<Main> mainList = mainMapper.selectByExample(mainExample);

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
