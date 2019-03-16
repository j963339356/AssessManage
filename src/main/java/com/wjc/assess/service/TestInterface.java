package com.wjc.assess.service;

import com.wjc.assess.entity.Account;
import com.wjc.assess.entity.Totaltime;
import com.wjc.assess.entity.User;
import com.wjc.assess.utils.controller.dto.QueryList;

import java.util.List;

public interface TestInterface {
    void add(Account account);
    void delete(Account account);
    void updata(Account account);
    Account get(Account account);
    List<Account> getList(Account account,int page,int size);

    Account login(Account account);
    void regist(Account account);

/* test */
//    void add(User user);
//    void delete(User user);
//    void updata(User user);
//    User get(User user);
//    User get(int id);
}
