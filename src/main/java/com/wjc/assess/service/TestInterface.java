package com.wjc.assess.service;

import com.wjc.assess.entity.User;
import com.wjc.assess.utils.controller.dto.ReturnList;

import java.util.List;

public interface TestInterface {
    void add(User account);
    void delete(String[] ids);
    void updata(User account);
//    User get(User account);
    ReturnList getList(User account, int page, int size);

    User login(User account);
    void regist(User account);

/* test */
//    void add(User user);
//    void delete(User user);
//    void updata(User user);
//    User get(User user);
//    User get(int id);
}
