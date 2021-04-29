package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.User;
import com.lainey.wiki.domain.UserExample;
import com.lainey.wiki.mapper.UserMapper;
import com.lainey.wiki.req.UserQueryReq;
import com.lainey.wiki.req.UserSaveReq;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.resp.UserQueryResp;
import com.lainey.wiki.util.CopyUtil;
import com.lainey.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<UserQueryResp> list(UserQueryReq req){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getLoginName())){
            criteria.andLoginNameEqualTo(req.getLoginName());
        }

        PageHelper.startPage(req.getPage(),req.getSize());
        List<User> userList = userMapper.selectByExample(userExample);

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

      /*  List<UserResp> respList = new ArrayList<>();
        for (User user : userList) {
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(user,userResp);
            // userResp.setBz("备注"); 该句是用来测试是否生效的
            respList.add(userResp);
        }*/

        // 列表复制
        List<UserQueryResp> list = CopyUtil.copyList(userList, UserQueryResp.class);

        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp ;
    }

    /**
     * 保存
     * @param req
     */
    public void save(UserSaveReq req) {
        User user = CopyUtil.copy(req, User.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            // user.setId(snowFlake.nextId());
            userMapper.insert(user);
        } else {
            // 更新
            userMapper.updateByPrimaryKey(user);
        }
    }

    public void delete(Long id){
        userMapper.deleteByPrimaryKey(id);
    }


}
