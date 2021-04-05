package com.lainey.wiki.service;

import com.lainey.wiki.domain.Ebook;
import com.lainey.wiki.domain.EbookExample;
import com.lainey.wiki.mapper.EbookMapper;
import com.lainey.wiki.req.EbookReq;
import com.lainey.wiki.resp.EbookResp;
import com.lainey.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook:ebookList) {
//            // EbookResp ebookResp =new EbookResp();
//            // BeanUtils.copyProperties(ebook,ebookResp);// 该方法：从ebook这个类拷贝到ebookResp这个类
//            //对象复制
//            EbookResp ebookResp = CopyUtil.copy(ebook,EbookResp.class);
//            //列表复制
//            respList.add(ebookResp);
//        }
        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);
        return list;
    }
}
