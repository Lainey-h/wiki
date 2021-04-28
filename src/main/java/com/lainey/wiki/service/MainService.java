package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.Main;
import com.lainey.wiki.domain.MainExample;
import com.lainey.wiki.mapper.MainMapper;
import com.lainey.wiki.req.MainQueryReq;
import com.lainey.wiki.req.MainSaveReq;
import com.lainey.wiki.resp.MainQueryResp;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainService {

    private static final Logger LOG = LoggerFactory.getLogger(MainService.class);

    @Resource
    private MainMapper mainMapper;

//    @Resource
//    private SnowFlake snowFlake;


    public PageResp<MainQueryResp> list(MainQueryReq req){
        MainExample mainExample = new MainExample();
        MainExample.Criteria criteria=mainExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getAlbh())){
            criteria.andAlbhEqualTo(req.getAlbh());
        }

        PageHelper.startPage(req.getPage(),req.getSize());
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

        // 列表复制
        List<MainQueryResp> list = CopyUtil.copyList(mainList, MainQueryResp.class);

        PageResp<MainQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp ;
    }

    /**
     * 保存
     * @param req
     */
    public void save(MainSaveReq req) {
        Main main = CopyUtil.copy(req, Main.class);
        if (ObjectUtils.isEmpty(req.getAlbh())) {
            // 新增
            // main.setAlbh(snowFlake.nextId());
            mainMapper.insert(main);
        } else {
            // 更新
            mainMapper.updateByPrimaryKey(main);
        }
    }

    public void delete(Long albh){
        mainMapper.deleteByPrimaryKey(albh);
    }


    public Main listByAlbh(Long albh){
          Main listByAlbh= mainMapper.selectByPrimaryKey(albh);
//        MainExample mainExample = new MainExample();
//        MainExample.Criteria criteria=mainExample.createCriteria();
//        criteria.andAlbhEqualTo(req.getAlbh());
//        List<Main> mainList = mainMapper.selectByExample(mainExample);
        // List<MainQueryResp> listByAlbh = CopyUtil.copyList(mainList, MainQueryResp.class);
          return listByAlbh ;
    }

}
