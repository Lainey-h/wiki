package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.All;
import com.lainey.wiki.domain.Fszz;
import com.lainey.wiki.domain.Jsjg;
import com.lainey.wiki.domain.Main;
import com.lainey.wiki.mapper.FszzMapper;
import com.lainey.wiki.mapper.JsjgMapper;
import com.lainey.wiki.mapper.MainMapper;
import com.lainey.wiki.req.AllQueryReq;
import com.lainey.wiki.req.AllSaveReq;
import com.lainey.wiki.resp.AllQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllService {

    private static final Logger LOG = LoggerFactory.getLogger(AllService.class);

    @Resource
    private MainMapper mainMapper;
    @Resource
    private FszzMapper fszzMapper;
    @Resource
    private JsjgMapper jsjgMapper;

    public PageResp<AllQueryResp> list(AllQueryReq req){
        PageHelper.startPage(req.getPage(),req.getSize());
        List<All> mainList = mainMapper.settAll();

        PageInfo<All> pageInfo = new PageInfo<>(mainList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        // 列表复制
        List<AllQueryResp> list = CopyUtil.copyList(mainList, AllQueryResp.class);
        PageResp<AllQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp ;
    }

    /**
     * 保存
     * @param req
     * 这个是你之前写的？这个是我尝试写的三个表的保存接口 应该是错的 所以注释掉了 我记得之前你好像在mainconrtoller里写的桑格表的接口
     */
    @Transient
    public void save(AllSaveReq req) {
        Main main = CopyUtil.copy(req, Main.class);
        Fszz fszz = CopyUtil.copy(req, Fszz.class);
        Jsjg jsjg = CopyUtil.copy(req, Jsjg.class);// debug模式启动下
        if (ObjectUtils.isEmpty(req.getAlbh())) {
            // 新增
            // all.setAlbh(snowFlake.nextId());// 雪花算法 uuid我不懂 当时就觉得自增最简单 ，UUID是根据时间戳生成的 ，前八位也是随机数，你也可以查下数据库看最大值是多少，你这块自增一就可以
            Long maxAlbh = mainMapper.queryMaxAlbh();
            main.setAlbh(maxAlbh+1);
            fszz.setAlbh(maxAlbh+1);
            jsjg.setAlbh(maxAlbh+1);
            mainMapper.insert(main);
            fszzMapper.insert(fszz);
            jsjgMapper.insert(jsjg); //这块就是判断albh是否为空 为空就新增（insert 对的，你加ID就在这加就行）  那数据库中当时设置的是id 自动增加 auto_ 数据库自增无所谓，你带值的话他就不增了，不带值人家也自增 懂了~ 那怎么获取最后一个案例的albh 然后让他++？
                // 一般是查询数据库，求albh的最大值 写sql语句？对的 在mapper层？ 对的
            //三个表的都写嘛 协主表
        } else {
            // 更新
            mainMapper.updateByPrimaryKey(main);
            fszzMapper.updateByPrimaryKey(fszz);
            jsjgMapper.updateByPrimaryKey(jsjg);
        }
    }

    @Transient
    public void delete(Long albh){
        mainMapper.deleteByPrimaryKey(albh);
        fszzMapper.deleteByPrimaryKey(albh);
        jsjgMapper.deleteByPrimaryKey(albh);
    }




    public All listByAlbh(Long albh){
//        MainExample mainExample = new MainExample();
//        MainExample.Criteria criteria=mainExample.createCriteria();
//        criteria.andAlbhEqualTo(req.getAlbh());
//        List<Main> mainList = mainMapper.selectByExample(mainExample);
        // List<MainQueryResp> listByAlbh = CopyUtil.copyList(mainList, MainQueryResp.class);
        return mainMapper.selectByPrimaryKey(albh) ;
    }


}
