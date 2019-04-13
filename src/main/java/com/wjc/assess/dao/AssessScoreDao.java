package com.wjc.assess.dao;

import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;

import java.util.List;

public interface AssessScoreDao{
    int countByExample(AssessScoreExample example);

    List<AssessScore> selectByExample(AssessScoreExample example);
}
