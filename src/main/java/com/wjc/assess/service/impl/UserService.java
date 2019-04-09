package com.wjc.assess.service.impl;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.UserMapper;
import com.wjc.assess.entity.User;
import com.wjc.assess.entity.UserExample;
import com.wjc.assess.service.TestInterface;
import com.wjc.assess.utils.controller.dto.ReturnList;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional  //开启事务
public class UserService implements TestInterface {

    @Autowired
    private UserMapper accountMapper;

    @Autowired
    private JedisUtil redis;

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public void add(User account) {
        UserExample example = new UserExample();
        //每一个Criteria对象相当于“或”
        UserExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andUsernameEqualTo(account.getUsername());

        accountMapper.countByExample(example);
        //如果不存在账号
        if(accountMapper.countByExample(example) != 0){
            throw new CustomException(ExceptionEnum.LOGIN.getCode(),"账号已存在");
        }
        //生成其他属性
        account.setId(UUID.randomUUID().toString());
        account.setSysCreateTime(new Date());
        account.setSysStatus(1);
        //插入数据库
        accountMapper.insert(account);
    }

    @Override
    public void delete(String[] ids) {
        UserExample example = new UserExample();
        for (int i=0; i<ids.length; i++) {
            example.or().andIdEqualTo(ids[i]);
        }

        User user = new User();
        user.setSysStatus(2);
        accountMapper.updateByExampleSelective(user,example);
    }

    @Override
    public void updata(User account) {

    }

    //获取单个用户
    public User get(String id) {
        User user = accountMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public ReturnList getList(User account,int page,int size) {
        //分页
        PageHelper.startPage(page,size);

        UserExample example = new UserExample();
        //每一个Criteria对象相当于“或”
        UserExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusBetween(0,1);
        criteria.andOrgCodeNotEqualTo(0);
        if(account.getUsername()!=null && !account.getUsername().equals("")){
            criteria.andUsernameLike("%"+account.getUsername()+"%");
        }

        int count = accountMapper.countByExample(example);
        List<User> list = accountMapper.selectByExample(example);
        ReturnList result = new ReturnList(count,list);
        return result;
    }

    @Override
    public User login(User account) {
        UserExample example = new UserExample();
        //每一个Criteria对象相当于“或”
        UserExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andUsernameEqualTo(account.getUsername());

        List<User> list = accountMapper.selectByExample(example);
        if(list.size() == 0){
            throw new CustomException(ExceptionEnum.LOGIN.getCode(),"账号不存在");
        }
        User login = list.get(0);
        if(!login.getPassword().equals(account.getPassword())){
            throw new CustomException(ExceptionEnum.LOGIN.getCode(),"密码错误");
        }
        return login;
    }

    @Override
    public void regist(User account) {
        add(account);
    }


}
