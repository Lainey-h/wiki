package com.lainey.wiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lainey.wiki.domain.User;
import com.lainey.wiki.domain.UserExample;
import com.lainey.wiki.exception.BusinessException;
import com.lainey.wiki.exception.BusinessExceptionCode;
import com.lainey.wiki.mapper.UserMapper;
import com.lainey.wiki.req.UserLoginReq;
import com.lainey.wiki.req.UserQueryReq;
import com.lainey.wiki.req.UserResetPasswordReq;
import com.lainey.wiki.req.UserSaveReq;
import com.lainey.wiki.resp.PageResp;
import com.lainey.wiki.resp.UserLoginResp;
import com.lainey.wiki.resp.UserQueryResp;
import com.lainey.wiki.util.CopyUtil;
import com.lainey.wiki.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
            User userDB = selectByLoginName(req.getLoginName()); // userDB 表示从数据库里查出来的用户名
            if (ObjectUtils.isEmpty(userDB)) {
                // 新增
                // user.setId(snowFlake.nextId());
                userMapper.insert(user);
            }else {
                //用户名已存在 抛出自定义异常
                throw new BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
            // 更新
            user.setLoginName(null); // 修改的时候不修改用户名
            user.setPassword(null);
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    public void delete(Long id){
        userMapper.deleteByPrimaryKey(id);
    }

    public User selectByLoginName(String loginName){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)){
            return null;
        }else {
            return userList.get(0);
        }
    }


    /**
     * 重置密码
     * @param req
     */
    public void ResetPassword(UserResetPasswordReq req) {
        User user = CopyUtil.copy(req, User.class); // 拷贝 拷贝成数据库的实体user 这个req只有id和password有值 这里的user跟req有一个字段映射的 也只有id和password有值
        userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * 登录
     */
    public UserLoginResp login(UserLoginReq req) {
        User userDb = selectByLoginName(req.getLoginName());
        if (ObjectUtils.isEmpty(userDb)){
            // 用户名不存在
            LOG.info("用户名不存在,{}",req.getLoginName());
            throw new BusinessException(BusinessExceptionCode.USER_USER_ERROR); // 无论是密码不正确还是用户名不存在 都给前端一个模糊的提示   但是日志打印应该越详细越好 方便生产运维 不能坑自己
        }else{
            if (userDb.getPassword().equals(req.getPassword())){
                // 登录成功
                UserLoginResp userLoginResp = CopyUtil.copy(userDb,UserLoginResp.class);
                return userLoginResp;
            }

        else {
            // 密码不正确
            LOG.info("密码不正确,{}",req.getPassword(),userDb.getPassword());
            throw new BusinessException(BusinessExceptionCode.USER_USER_ERROR); // 无论是密码不正确还是用户名不存在 都给前端一个模糊的提示
            }
        }
    }

}
