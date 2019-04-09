package com.wjc.assess.dao;

import com.wjc.assess.entity.AssessManage;
import com.wjc.assess.entity.AssessManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessManageMapper {
    int countByExample(AssessManageExample example);

    int deleteByExample(AssessManageExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssessManage record);

    int insertSelective(AssessManage record);

    List<AssessManage> selectByExample(AssessManageExample example);

    AssessManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssessManage record, @Param("example") AssessManageExample example);

    int updateByExample(@Param("record") AssessManage record, @Param("example") AssessManageExample example);

    int updateByPrimaryKeySelective(AssessManage record);

    int updateByPrimaryKey(AssessManage record);
}