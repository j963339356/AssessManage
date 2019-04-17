package com.wjc.assess.service;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.Enum.ExceptionEnum;
import com.wjc.assess.Exception.CustomException;
import com.wjc.assess.dao.AssessManageMapper;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.dto.ManageDto;
import com.wjc.assess.entity.*;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 考核管理
 */
@Service
@Transactional  //开启事务
public class ManageService {
    @Autowired
    AssessManageMapper manageDao;   //管理
    @Autowired
    AssessScoreMapper scoreDao; //分数

    //查询
    public ReturnList getList(AssessManage manage, int page, int size){
        AssessManageExample example = new AssessManageExample();
        //每一个Criteria对象相当于“或”
        AssessManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());  //年度
        example.setOrderByClause("sysUpdateTime desc,sysCreateTime desc");  //先按更新时间降序，在按创建时间降序

        if(manage.getCity()!=null && !manage.getCity().equals("")){ //辖区市
            criteria.andCityEqualTo(manage.getCity());
        }
        if(manage.getCounty()!=null && !manage.getCounty().equals("")){ //辖区县
            criteria.andCountyEqualTo(manage.getCounty());
        }else{
            //如果不是县级，则不显示没提交的
            List<Integer> statusList = new ArrayList<>();
            statusList.add(1);
            statusList.add(2);
            statusList.add(3);
            statusList.add(4);
            statusList.add(7);
            criteria.andStatusIn(statusList);
        }
        if(manage.getOrgName()!=null && !manage.getOrgName().equals("")){ //单位名称
            criteria.andOrgNameEqualTo(manage.getOrgName());
        }
        if(manage.getStatus()!=null && !manage.getStatus().equals("")){ // 公示状态
            criteria.andStatusEqualTo(manage.getStatus());
        }

        int total = manageDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<AssessManage> list = manageDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //公示信息列表
    public ReturnList noticeList(AssessManage manage, int page, int size,int isnotice){
        AssessManageExample example = new AssessManageExample();
        //每一个Criteria对象相当于“或”
        AssessManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());  //年度
        example.setOrderByClause("sysUpdateTime desc,sysCreateTime desc");  //先按更新时间降序，在按创建时间降序

        if(manage.getCity()!=null && !manage.getCity().equals("")){ //辖区市
            criteria.andCityEqualTo(manage.getCity());
        }
        if(manage.getCounty()!=null && !manage.getCounty().equals("")){ //辖区县
            criteria.andCountyEqualTo(manage.getCounty());
        }
        if(manage.getOrgName()!=null && !manage.getOrgName().equals("")){ //单位名称
            criteria.andOrgNameEqualTo(manage.getOrgName());
        }
        if(isnotice == 1){
            criteria.andStatusEqualTo(4);
        }
        else if(isnotice == 2){
            List<Integer> statusList = new ArrayList<>();
            statusList.add(2);
            statusList.add(3);
            statusList.add(4);
            criteria.andStatusIn(statusList);
        }

        int total = manageDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<AssessManage> list = manageDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //市级上报列表
    public ReturnList cityReportList(AssessManage manage, int page, int size){
        AssessManageExample example = new AssessManageExample();
        AssessManageExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());  //年度
        criteria.andNoticeEndLessThanOrEqualTo(new Date());  //小于当前时间
        example.setOrderByClause("sysUpdateTime desc,sysCreateTime desc");  //先按更新时间降序，在按创建时间降序

        if(manage.getCity()!=null && !manage.getCity().equals("")){ //辖区市
            criteria.andCityEqualTo(manage.getCity());
        }
        criteria.andStatusEqualTo(2);   //市级已公示且大于公示结束时间

        int total = manageDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<AssessManage> list = manageDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //工作项待处理列表
    public ReturnList waittaskList(AssessManage manage, int page, int size,User user){
        AssessManageExample example = new AssessManageExample();
        //每一个Criteria对象相当于“或”
        AssessManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        example.setOrderByClause("sysUpdateTime desc,sysCreateTime desc");  //先按更新时间降序，在按创建时间降序

        if(manage.getProcessName()!=null && !manage.getProcessName().equals("")){ // 流程名称
            criteria.andProcessNameLike("%"+manage.getProcessName()+"%");
        }
        if(user.getProvince()!=null && !user.getProvince().equals("")){ //同一个省
            criteria.andProvinceEqualTo(user.getProvince());
        }
        List<Integer> statusList = new ArrayList<>();
        if(user.getCity()!=null && !user.getCity().equals("")){ //同一个市
            criteria.andCityEqualTo(user.getCity());
            statusList.add(5);
            statusList.add(8);
        }
        else{   //如果不是市级那就是省级
            statusList.add(6);
        }
        criteria.andStatusIn(statusList);
//        criteria.andOrgCodeEqualTo(Integer.toString(user.getOrgCode()+1));  //查看上一级的上报

        int total = manageDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<AssessManage> list = manageDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //创建
    public void add(ManageDto manageDto, User user){
        AssessManageExample example = new AssessManageExample();
        //每一个Criteria对象相当于“或”
        AssessManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        criteria.andCountyEqualTo(user.getCounty());
        if(manageDao.countByExample(example)>0){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"考核已存在");
        }

        //考核管理
        AssessManage assessManage = new AssessManage();
        assessManage.setId(UUID.randomUUID().toString());
        assessManage.setCity(user.getCity());
        assessManage.setProvince(user.getProvince());
        assessManage.setCounty(user.getCounty());
        assessManage.setCountyScore(manageDto.getCountyScore());
        assessManage.setOrgCode(user.getOrgCode().toString());
        assessManage.setOrgName(user.getOrgName());
        assessManage.setYear(2018);
        assessManage.setWriterId(user.getId());
        assessManage.setWriterName(user.getName());
        assessManage.setWriteDate(new Date());
        assessManage.setSysCreateCode(user.getOrgCode().toString());
        assessManage.setSysCreateName(user.getName());
        assessManage.setSysCreateTime(new Date());
        assessManage.setSysStatus(1);
        manageDao.insert(assessManage);
        //考核分数
        List<AssessScore> list = manageDto.getScoreList();
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setId(UUID.randomUUID().toString());
            assessScore.setYear(2018);
            assessScore.setCounty(user.getCounty());
            assessScore.setCity(user.getCity());
            assessScore.setProvince(user.getProvince());
            assessScore.setOrgCode(user.getOrgCode());
            assessScore.setOgrName(user.getOrgName());
            assessScore.setSysCreateCode(user.getOrgCode().toString());
            assessScore.setSysCreateName(user.getName());
            assessScore.setSysCreateTime(new Date());
            assessScore.setSysStatus(1);
            scoreDao.insert(assessScore);
        }
    }

    //公示
    public void publicity(List<String> ids,User user){
        if(user.getOrgCode()!=1 && user.getOrgCode()!=2){
            throw new CustomException(ExceptionEnum.BUSINESS.getCode(),"不符合权限");
        }
        AssessManageExample example = new AssessManageExample();
        for(int i=0; i<ids.size(); i++){
            example.or().andIdEqualTo(ids.get(i));
        }
        AssessManage assessManage = new AssessManage();
        if(user.getOrgCode()==2){   //市级公示
            assessManage.setStatus(2);
        }
        if(user.getOrgCode()==1){   //省级公示
            assessManage.setStatus(4);
        }
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE,5);
        assessManage.setNoticeStart(new Date());    //公示时间
        assessManage.setNoticeEnd(c1.getTime());
        assessManage.setWriterId(user.getId());
        assessManage.setWriterName(user.getName());
        assessManage.setWriteDate(new Date());
        assessManage.setWriterPhone(user.getPhone());
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByExampleSelective(assessManage,example);
    }

    //县级上报
    public void countyReport(ManageDto manageDto, User user){
        //考核管理
        AssessManage assessManage = new AssessManage();
        assessManage.setStatus(5);  //市级核定
        assessManage.setBackReson("");
        assessManage.setCounty(manageDto.getCounty());
        assessManage.setCity(manageDto.getCity());
        assessManage.setCountyScore(manageDto.getCountyScore());
        assessManage.setProcessName("城乡客运发展考核县级上报流程");
        updateByExample(assessManage,user);
        //考核分数
        List<AssessScore> list = manageDto.getScoreList();
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setCounty(manageDto.getCounty());
            assessScore.setCity(manageDto.getCity());
            updateScoreByExample(assessScore,user);
        }
    }

    //市级上报
    public void cityReport(List<String> ids, User user){
        //考核管理
        AssessManageExample example = new AssessManageExample();
        for(int i=0; i<ids.size(); i++){
            example.or().andIdEqualTo(ids.get(i));
        }
        AssessManage assessManage = new AssessManage();
        assessManage.setStatus(6);  //市级核定
        assessManage.setBackReson("");
        assessManage.setProcessName("城乡客运发展考核市级上报流程");
        assessManage.setOrgCode(user.getOrgCode().toString());
        assessManage.setOrgName(user.getOrgName());
        assessManage.setWriterId(user.getId());
        assessManage.setWriterName(user.getName());
        assessManage.setWriterPhone(user.getPhone());
        assessManage.setWriteDate(new Date());
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByExampleSelective(assessManage,example);
    }

    //市级上报删除县级考核
    public void deleteCounty(List<String> ids, User user){
        //删除考核报告
        AssessManageExample example = new AssessManageExample();
        for(int i=0; i<ids.size(); i++){
            example.or().andIdEqualTo(ids.get(i));
        }
        AssessManage assessManage = new AssessManage();
        assessManage.setSysStatus(2);  //逻辑删除
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByExampleSelective(assessManage,example);

        //删除考核成绩就
        AssessManageExample example2 = new AssessManageExample();
        for(int i=0; i<ids.size(); i++){
            example2.or().andIdEqualTo(ids.get(i));
        }
        List<AssessManage> list = manageDao.selectByExample(example);
        AssessScoreExample example3 = new AssessScoreExample();
        for(int i=0; i<list.size(); i++){
            AssessManage am = list.get(i);
            example3.or().andCityEqualTo(am.getCity())
                    .andCountyEqualTo(am.getCounty())
                    .andSysStatusEqualTo(1);
        }
        AssessScore assessScore = new AssessScore();
        assessScore.setSysUpdateCode(user.getOrgCode().toString());
        assessScore.setSysUpdateName(user.getName());
        assessScore.setSysUpdateTime(new Date());
        assessScore.setSysStatus(2);
        scoreDao.updateByExampleSelective(assessScore,example3);
    }

    //市级核定
    public void cityAssess(ManageDto manageDto, User user){
        //考核管理
        AssessManage assessManage = new AssessManage();
        assessManage.setStatus(1);  //市级待公示
        assessManage.setProcessName("市级核定流程");
        assessManage.setCityScore(manageDto.getCityScore());
        assessManage.setCounty(manageDto.getCounty());
        assessManage.setCity(manageDto.getCity());
        updateByExample(assessManage,user);
        //考核分数
        List<AssessScore> list = manageDto.getScoreList();
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setCounty(manageDto.getCounty());
            assessScore.setCity(manageDto.getCity());
            updateScoreByExample(assessScore,user);
        }
    }

    //省级核定
    public void provinceAssess(ManageDto manageDto, User user){
        //考核管理
        AssessManage assessManage = new AssessManage();
        assessManage.setStatus(3);  //省级待公示
        assessManage.setProcessName("省级核定流程");
        assessManage.setProvinceScore(manageDto.getProvinceScore());
        String level = "A";
        for(int i=0; i<5; i++){
            if((manageDto.getProvinceScore()-240)>0){
                level += "A";
            }
        }
        assessManage.setLevel(level);
        assessManage.setCounty(manageDto.getCounty());
        assessManage.setCity(manageDto.getCity());
        updateByExample(assessManage,user);
        //考核分数
        List<AssessScore> list = manageDto.getScoreList();
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setCounty(manageDto.getCounty());
            assessScore.setCity(manageDto.getCity());
            updateScoreByExample(assessScore,user);
        }
    }

    //市级退回
    public void cityBack(AssessManage manage,User user){
        AssessManage assessManage = manageDao.selectByPrimaryKey(manage.getId());
        assessManage.setBackReson(manage.getBackReson());
        assessManage.setProcessName("市级退回流程");
        assessManage.setStatus(7);
        assessManage.setCityScore(null);
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByPrimaryKey(assessManage);
        //考核分数
        AssessScoreExample example = new AssessScoreExample();
        example.or().andCityEqualTo(assessManage.getCity())
                .andCountyEqualTo(assessManage.getCounty());
        List<AssessScore> list = scoreDao.selectByExample(example);
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setCityScore(null);
            assessScore.setSysUpdateCode(user.getOrgCode().toString());
            assessScore.setSysUpdateName(user.getName());
            assessScore.setSysUpdateTime(new Date());
            scoreDao.updateByPrimaryKey(assessScore);
        }
    }

    //省级退回
    public void provinceBack(AssessManage manage,User user){
        AssessManage assessManage = manageDao.selectByPrimaryKey(manage.getId());
        assessManage.setBackReson(manage.getBackReson());
        assessManage.setProcessName("省级退回流程");
        assessManage.setStatus(8);
        assessManage.setProvinceScore(null);
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByPrimaryKey(assessManage);
        //考核分数
        AssessScoreExample example = new AssessScoreExample();
        example.or().andCityEqualTo(assessManage.getCity())
                .andCountyEqualTo(assessManage.getCounty());
        List<AssessScore> list = scoreDao.selectByExample(example);
        for(int i=0; i<list.size(); i++){
            AssessScore assessScore = list.get(i);
            assessScore.setCityScore(null);
            assessScore.setSysUpdateCode(user.getOrgCode().toString());
            assessScore.setSysUpdateName(user.getName());
            assessScore.setSysUpdateTime(new Date());
            scoreDao.updateByPrimaryKey(assessScore);
        }
    }

    //更新考核管理
    public void updateByExample(AssessManage assessManage, User user){
        AssessManageExample example = new AssessManageExample();
        AssessManageExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        if(assessManage.getCounty()!=null) {
            criteria.andCountyEqualTo(assessManage.getCounty());
        }
        if(assessManage.getCity()!=null) {
            criteria.andCityEqualTo(assessManage.getCity());
        }

        assessManage.setOrgCode(user.getOrgCode().toString());
        assessManage.setOrgName(user.getOrgName());
        assessManage.setWriterId(user.getId());
        assessManage.setWriterName(user.getName());
        assessManage.setWriterPhone(user.getPhone());
        assessManage.setWriteDate(new Date());
        assessManage.setSysUpdateCode(user.getOrgCode().toString());
        assessManage.setSysUpdateName(user.getName());
        assessManage.setSysUpdateTime(new Date());
        manageDao.updateByExampleSelective(assessManage,example);
    }

    //更新分数
    public void updateScoreByExample(AssessScore assessScore,User user){
        AssessScoreExample example = new AssessScoreExample();
        AssessScoreExample.Criteria criteria = example.createCriteria();
        criteria.andSysStatusEqualTo(1);
        criteria.andNameEqualTo(assessScore.getName());
        criteria.andPEqualTo(assessScore.getP());
        criteria.andCountyEqualTo(assessScore.getCounty());
        criteria.andCityEqualTo(assessScore.getCity());

        assessScore.setOrgCode(user.getOrgCode());
        assessScore.setOgrName(user.getOrgName());
        assessScore.setSysUpdateCode(user.getOrgCode().toString());
        assessScore.setSysUpdateName(user.getName());
        assessScore.setSysUpdateTime(new Date());
        scoreDao.updateByExampleSelective(assessScore,example);
    }
}
