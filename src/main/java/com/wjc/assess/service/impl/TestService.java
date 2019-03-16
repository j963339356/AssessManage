package com.wjc.assess.service.impl;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.AccountMapper;
import com.wjc.assess.dao.TotaltimeMapper;
import com.wjc.assess.dao.UserMapper;
import com.wjc.assess.entity.Account;
import com.wjc.assess.entity.AccountExample;
import com.wjc.assess.entity.Totaltime;
import com.wjc.assess.service.TestInterface;
import com.wjc.assess.utils.controller.dto.QueryList;
import com.wjc.assess.utils.redis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional  //开启事务
public class TestService implements TestInterface {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private JedisUtil redis;

//    @Autowired
//    private UserMapper userMapper;

    @Override
    public void add(Account account) {
        AccountExample example = new AccountExample();
        //每一个Criteria对象相当于“或”
        AccountExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andUsernameEqualTo(account.getUsername());

        accountMapper.countByExample(example);
        //如果不存在账号
        if(accountMapper.countByExample(example) != 0){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"账号已存在");
        }
        //生成其他属性
        account.setId(UUID.randomUUID().toString());
        account.setSyscreatetime(new Date());
        account.setSysupdatetime(new Date());
        account.setSysstatics(0);
        //插入数据库
        accountMapper.insert(account);
    }

    @Override
    public void delete(Account account) {

    }

    @Override
    public void updata(Account account) {

    }

    @Override
    public Account get(Account account) {
        AccountExample example = new AccountExample();
        //每一个Criteria对象相当于“或”
        AccountExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andUsernameEqualTo(account.getUsername());

        List<Account> list = accountMapper.selectByExample(example);
        if(list.size() == 0){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"账号不存在");
        }
        return list.get(0);
    }

    @Override
    public List<Account> getList(Account account,int page,int size) {
        //分页
        PageHelper.startPage(page,size);

        AccountExample example = new AccountExample();
        //每一个Criteria对象相当于“或”
        AccountExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andPasswordEqualTo(account.getPassword());

        List<Account> list = accountMapper.selectByExample(example);
        return list;
    }

    @Override
    public Account login(Account account) {
        Account login = get(account);
        if(!login.getPassword().equals(account.getPassword())){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"密码错误");
        }
        return login;
    }

    @Override
    public void regist(Account account) {
        add(account);
    }


}
