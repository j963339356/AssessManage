package com.wjc.assess.dao;

import com.wjc.assess.entity.AssessTargetManage;
import com.wjc.assess.entity.AssessTargetManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssessTargetManageMapper {
    int countByExample(AssessTargetManageExample example);

    int deleteByExample(AssessTargetManageExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssessTargetManage record);

    int insertSelective(AssessTargetManage record);

    List<AssessTargetManage> selectByExample(AssessTargetManageExample example);

    AssessTargetManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssessTargetManage record, @Param("example") AssessTargetManageExample example);

    int updateByExample(@Param("record") AssessTargetManage record, @Param("example") AssessTargetManageExample example);

    int updateByPrimaryKeySelective(AssessTargetManage record);

    int updateByPrimaryKey(AssessTargetManage record);
}