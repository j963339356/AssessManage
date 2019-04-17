package com.wjc.assess.dao;

import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssessScoreDao{
    int countByExample(AssessScoreExample example);

    List<AssessScore> selectByExample(@Param("page") int page, @Param("size") int size, @Param("example") AssessScoreExample example);
}
