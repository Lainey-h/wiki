package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.All;
import com.lainey.wiki.domain.Jsjg;
import com.lainey.wiki.domain.JsjgExample;
import com.lainey.wiki.mapper.FszzMapper;
import com.lainey.wiki.mapper.JsjgMapper;
import com.lainey.wiki.mapper.MainMapper;
import com.lainey.wiki.req.JsjgQueryReq;
import com.lainey.wiki.req.JsjgSaveReq;
import com.lainey.wiki.resp.JsjgQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@Service
public class JsjgService {

    private static final Logger LOG = LoggerFactory.getLogger(JsjgService.class);

    @Resource
    private JsjgMapper jsjgMapper;

    @Resource
    MainMapper mainMapper;
    @Resource
    FszzMapper fszzMapper;

//    @Resource
//    private SnowFlake snowFlake;


    public PageResp<JsjgQueryResp> list(JsjgQueryReq req){
        JsjgExample jsjgExample = new JsjgExample();
        JsjgExample.Criteria criteria=jsjgExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getAlbh())){
            criteria.andAlbhEqualTo(req.getAlbh());
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<Jsjg> jsjgList = jsjgMapper.selectByExample(jsjgExample);

        PageInfo<Jsjg> pageInfo = new PageInfo<>(jsjgList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

      /*  List<JsjgResp> respList = new ArrayList<>();
        for (Jsjg jsjg : jsjgList) {
            JsjgResp jsjgResp = new JsjgResp();
            BeanUtils.copyProperties(jsjg,jsjgResp);
            // jsjgResp.setBz("备注"); 该句是用来测试是否生效的
            respList.add(jsjgResp);
        }*/

        // 列表复制
        List<JsjgQueryResp> list = CopyUtil.copyList(jsjgList, JsjgQueryResp.class);

        PageResp<JsjgQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp ;
    }

    /**
     * 保存
     * @param req
     */
    public void save(JsjgSaveReq req) {
        Jsjg jsjg = CopyUtil.copy(req, Jsjg.class);
        if (ObjectUtils.isEmpty(req.getAlbh())) {
            // 新增
            // jsjg.setAlbh(snowFlake.nextId());
            jsjgMapper.insert(jsjg);
        } else {
            // 更新
            jsjgMapper.updateByPrimaryKey(jsjg);
        }
    }

    public void delete(Long albh){
        jsjgMapper.deleteByPrimaryKey(albh);
    }

    @Transient
    public void update(All all) {

        //用的更新接口是save 你看，你先写，不会再问

        //分别调用各个表的更新方法，根据all里的主键，一个一个更新就行了   那把这三个表的更新方法都写到这个里面 然后调用就ok吗  把对应的Dao注入进来直接调
    }
}
