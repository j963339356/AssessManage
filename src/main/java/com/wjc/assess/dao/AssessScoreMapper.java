package com.wjc.assess.dao;

import com.wjc.assess.entity.AssessScore;
import com.wjc.assess.entity.AssessScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessScoreMapper {
    int countByExample(AssessScoreExample example);

    int deleteByExample(AssessScoreExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssessScore record);

    int insertSelective(AssessScore record);

    List<AssessScore> selectByExample(AssessScoreExample example);

    AssessScore selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssessScore record, @Param("example") AssessScoreExample example);

    int updateByExample(@Param("record") AssessScore record, @Param("example") AssessScoreExample example);

    int updateByPrimaryKeySelective(AssessScore record);

    int updateByPrimaryKey(AssessScore record);
}