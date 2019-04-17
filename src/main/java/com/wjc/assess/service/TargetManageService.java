package com.wjc.assess.service;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.AssessScoreDao;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.dao.AssessTargetManageMapper;
import com.wjc.assess.entity.*;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 指标管理
 */
@Service
@Transactional  //开启事务
public class TargetManageService {
    @Autowired
    private AssessTargetManageMapper targetDao;

    @Autowired
    private AssessScoreDao scoreDao;

    //查询
    public ReturnList getList(AssessTargetManage targetManage, int page, int size){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        if(targetManage.getName()!= null && !targetManage.getName().equals("")){
            criteria.andNameLike("%"+targetManage.getName()+"%");   //指标名称
        }
        if(targetManage.getP()!= null && !targetManage.getP().equals("")) {
            criteria.andPEqualTo(targetManage.getP());    //指标分类
        }

        int total = targetDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<AssessTargetManage> list = targetDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //查询，蛋疼这个模块被舍弃了
    public ReturnList getList2(AssessTargetManage targetManage, int page, int size){
        AssessScoreExample example = new AssessScoreExample();
        //每一个Criteria对象相当于“或”
        AssessScoreExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);

        if(targetManage.getName()!= null && !targetManage.getName().equals("")){
            criteria.andNameLike("%"+targetManage.getName()+"%");   //指标名称
        }
        if(targetManage.getP()!= null && !targetManage.getP().equals("")) {
            criteria.andPEqualTo(targetManage.getP());    //指标分类
        }

        int total = scoreDao.countByExample(example);

        List<AssessScore> list = scoreDao.selectByExample((page-1)*size,size,example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //创建
    public void add(AssessTargetManage targetManage, User user){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        //不允许创建同名指标
        criteria.andSysStatusEqualTo(1);
        criteria.andNameEqualTo(targetManage.getName());

        if(targetDao.countByExample(example) != 0){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"不允许创建同名的指标");
        }

        //插入数据库
        if(targetManage.getLevel() != 1){ //子指标
            targetManage.setAssessId(targetManage.getId()); //使用主指标id
        }
        targetManage.setId(UUID.randomUUID().toString());
        targetManage.setIsStart(true);    //启用指标
        targetManage.setOrgCode(user.getOrgCode());
        targetManage.setSysCreateCode(user.getOrgCode().toString());
        targetManage.setSysCreateName(user.getName());
        targetManage.setSysCreateTime(new Date());
        targetManage.setSysStatus(1);     //1正常，2删除

        targetDao.insert(targetManage);
    }

    //修改
    public void  update(AssessTargetManage target, User user){
        //插入数据库
        target.setSysUpdateCode(user.getOrgCode().toString());
        target.setSysUpdateName(user.getName());
        target.setSysUpdateTime(new Date());
        targetDao.updateByPrimaryKey(target);
    }

    //删除
    public void delete(List<String> ids, User user){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        for(int i=0; i<ids.size(); i++){
            AssessTargetManage targetManage = get(ids.get(i));
            targetManage.setSysStatus(2);   //逻辑删除
            update(targetManage,user);
            criteria.andAssessIdEqualTo(targetManage.getId());  //找到子指标
            List<AssessTargetManage> list = targetDao.selectByExample(example);
            //逻辑删除子指标
            for(int j=0; j<list.size(); j++){
                AssessTargetManage target = list.get(j);
                target.setSysStatus(2);
                update(target,user);
            }
        }

    }

    //查看
    public AssessTargetManage get(String id){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        criteria.andSysStatusEqualTo(1);
        criteria.andIdEqualTo(id);
        List<AssessTargetManage> list = targetDao.selectByExample(example);
        return list.get(0);
    }

    //指标启用
    public void usingTarget(List<String> ids,User user){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        for(int i=0; i<ids.size(); i++){
            AssessTargetManage target = get(ids.get(i));
            target.setIsStart(true);
            update(target,user);
        }
    }

    //指标停用
    public void unUsingTarget(List<String> ids,User user){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        for(int i=0; i<ids.size(); i++){
            AssessTargetManage target = get(ids.get(i));
            target.setIsStart(false);
            update(target,user);
        }
    }

    //获取子指标列表
    public ReturnList dimensionList(String id){
        AssessTargetManageExample example = new AssessTargetManageExample();
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        criteria.andSysStatusEqualTo(1);
        criteria.andAssessIdEqualTo(id);

        int total = targetDao.countByExample(example);
        List<AssessTargetManage> list = targetDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //删除子指标
    public void dimensionDelete(List<String> ids, User user){
        AssessTargetManageExample example = new AssessTargetManageExample();
        //每一个Criteria对象相当于“或”
        AssessTargetManageExample.Criteria criteria = example.createCriteria();

        for(int i=0; i<ids.size(); i++){
            AssessTargetManage target = new AssessTargetManage();
            target.setId(ids.get(i));
            target.setSysStatus(2);
            update(target,user);
        }
    }
}
