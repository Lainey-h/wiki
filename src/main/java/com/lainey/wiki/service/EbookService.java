package com.lainey.wiki.service;

import com.lainey.wiki.domain.Ebook;
import com.lainey.wiki.domain.EbookExample;
import com.lainey.wiki.mapper.EbookMapper;
import com.lainey.wiki.req.EbookReq;
import com.lainey.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList= ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook:ebookList) {
            EbookResp ebookResp =new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);// 该方法：从ebook这个类拷贝到ebookResp这个类
            respList.add(ebookResp);
        }
        return respList;
    }
}
