package com.wjc.assess.service;

import com.github.pagehelper.PageHelper;
import com.wjc.assess.dao.AssessScoreMapper;
import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;
import com.wjc.assess.utils.controller.dto.ReturnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 考核分数管理
 */
@Service
@Transactional  //开启事务
public class ScoreService {
    @Autowired
    AssessScoreMapper scoreDao; //分数

    //查询
    public ReturnList getList(AssessManage manage){
        AssessScoreExample example = new AssessScoreExample();
        //每一个Criteria对象相当于“或”
        AssessScoreExample.Criteria criteria = example.createCriteria();
        //每一个Criteria里的方法相当于“与”
        criteria.andSysStatusEqualTo(1);
        criteria.andYearEqualTo(manage.getYear());  //年度

        if(manage.getCity()!=null && !manage.getCity().equals("")){ //辖区市
            criteria.andCityEqualTo(manage.getCity());
        }
        if(manage.getCounty()!=null && !manage.getCounty().equals("")){ //辖区县
            criteria.andCountyEqualTo(manage.getCounty());
        }

        int total = scoreDao.countByExample(example);
        //分页
        PageHelper.startPage(1,100);
        List<AssessScore> list = scoreDao.selectByExample(example);
        //返回的数据
        ReturnList result = new ReturnList(total,list);
        return result;
    }
}
