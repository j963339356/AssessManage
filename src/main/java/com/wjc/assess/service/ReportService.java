package com.wjc.assess.service;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.dao.EvaluateReportManageMapper;
import com.wjc.assess.entity.EvaluateReportManage;
import com.wjc.assess.entity.EvaluateReportManageExample;
import com.wjc.assess.entity.User;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 考核报告管理
 */
@Service
@Transactional  //开启事务
public class ReportService {
    @Autowired
    EvaluateReportManageMapper reportDao;

    @Autowired
    FileService fileService;

    //查询
    public ReturnList getList(EvaluateReportManage reportManage, int page, int size){
        EvaluateReportManageExample example = new EvaluateReportManageExample();
        //每一个Criteria对象相当于“或”
        EvaluateReportManageExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);

        if(reportManage.getYear()!=null && !reportManage.getYear().equals("")) {
            criteria.andYearEqualTo(reportManage.getYear());  //年度
        }

        int total = reportDao.countByExample(example);
        //分页
        PageHelper.startPage(page,size);
        List<EvaluateReportManage> list = reportDao.selectByExampleWithBLOBs(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }

    //创建
    public void add(EvaluateReportManage reportManage, User user) {
        EvaluateReportManageExample example = new EvaluateReportManageExample();
        EvaluateReportManageExample.Criteria criteria = example.createCriteria();

        reportManage.setId(UUID.randomUUID().toString());
        reportManage.setOrgCode(user.getOrgCode().toString());
        reportManage.setOrgName(user.getOrgName());
        reportManage.setSysCreateCode(user.getOrgCode().toString());
        reportManage.setSysCreateName(user.getName());
        reportManage.setSysCreateTime(new Date());
        reportManage.setSysUpdateCode(user.getOrgCode().toString());
        reportManage.setSysUpdateName(user.getName());
        reportManage.setSysUpdateTime(new Date());
        reportManage.setSysStatus(1);
        reportDao.insert(reportManage);
    }

    //修改
    public void update(EvaluateReportManage reportManage, User user){
        EvaluateReportManageExample example = new EvaluateReportManageExample();
        EvaluateReportManageExample.Criteria criteria = example.createCriteria();

        reportManage.setSysUpdateCode(user.getOrgCode().toString());
        reportManage.setSysUpdateName(user.getName());
        reportManage.setSysUpdateTime(new Date());
        reportDao.updateByPrimaryKeySelective(reportManage);
    }

    //删除
    public void delete(List<String> ids, User user){
        EvaluateReportManageExample example = new EvaluateReportManageExample();
        EvaluateReportManageExample.Criteria criteria = example.createCriteria();

        for(int i=0; i<ids.size(); i++) {
            example.or().andIdEqualTo(ids.get(i));
        }

        EvaluateReportManage reportManage = new EvaluateReportManage();
        reportManage.setSysStatus(2);
        reportManage.setSysUpdateCode(user.getOrgCode().toString());
        reportManage.setSysUpdateName(user.getName());
        reportManage.setSysUpdateTime(new Date());
        reportDao.updateByExampleSelective(reportManage,example);
    }

    //查看
    public EvaluateReportManage get(String id,User user){
        EvaluateReportManageExample example = new EvaluateReportManageExample();
        EvaluateReportManageExample.Criteria criteria = example.createCriteria();

        EvaluateReportManage reportManage = reportDao.selectByPrimaryKey(id);
        return reportManage;
    }

    //删除报告文件
    public void deleteFile(String id,String fileName){
        if(fileService.delete(fileName)){
              String fileId = fileName.substring(0,36);
              EvaluateReportManage report = new EvaluateReportManage();
              report.setId(id);
              report.setReportAddr("");
              reportDao.updateByPrimaryKeySelective(report);
        }
    }
}
