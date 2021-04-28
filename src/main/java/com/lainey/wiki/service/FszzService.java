package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.Fszz;
import com.lainey.wiki.domain.FszzExample;
import com.lainey.wiki.mapper.FszzMapper;
import com.lainey.wiki.req.FszzQueryReq;
import com.lainey.wiki.req.FszzSaveReq;
import com.lainey.wiki.resp.FszzQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FszzService {

    private static final Logger LOG = LoggerFactory.getLogger(FszzService.class);

    @Resource
    private FszzMapper fszzMapper;

//    @Resource
//    private SnowFlake snowFlake;


    public PageResp<FszzQueryResp> list(FszzQueryReq req){
        FszzExample fszzExample = new FszzExample();
        FszzExample.Criteria criteria=fszzExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getAlbh())){
            criteria.andAlbhEqualTo(req.getAlbh());
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<Fszz> fszzList = fszzMapper.selectByExample(fszzExample);

        PageInfo<Fszz> pageInfo = new PageInfo<>(fszzList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

      /*  List<FszzResp> respList = new ArrayList<>();
        for (Fszz fszz : fszzList) {
            FszzResp fszzResp = new FszzResp();
            BeanUtils.copyProperties(fszz,fszzResp);
            // fszzResp.setBz("备注"); 该句是用来测试是否生效的
            respList.add(fszzResp);
        }*/

        // 列表复制
        List<FszzQueryResp> list = CopyUtil.copyList(fszzList, FszzQueryResp.class);

        PageResp<FszzQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp ;
    }

    /**
     * 保存
     * @param req
     */
    public void save(FszzSaveReq req) {
        Fszz fszz = CopyUtil.copy(req, Fszz.class);
        if (ObjectUtils.isEmpty(req.getAlbh())) {
            // 新增
            // fszz.setAlbh(snowFlake.nextId());
            fszzMapper.insert(fszz);
        } else {
            // 更新
            fszzMapper.updateByPrimaryKey(fszz);
        }
    }

    public void delete(Long albh){
        fszzMapper.deleteByPrimaryKey(albh);
    }
}
