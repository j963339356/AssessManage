package com.wjc.assess.dao;

import com.wjc.assess.entity.EvaluateReportManage;
import com.wjc.assess.entity.EvaluateReportManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluateReportManageMapper {
    int countByExample(EvaluateReportManageExample example);

    int deleteByExample(EvaluateReportManageExample example);

    int deleteByPrimaryKey(String id);

    int insert(EvaluateReportManage record);

    int insertSelective(EvaluateReportManage record);

    List<EvaluateReportManage> selectByExampleWithBLOBs(EvaluateReportManageExample example);

    List<EvaluateReportManage> selectByExample(EvaluateReportManageExample example);

    EvaluateReportManage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EvaluateReportManage record, @Param("example") EvaluateReportManageExample example);

    int updateByExampleWithBLOBs(@Param("record") EvaluateReportManage record, @Param("example") EvaluateReportManageExample example);

    int updateByExample(@Param("record") EvaluateReportManage record, @Param("example") EvaluateReportManageExample example);

    int updateByPrimaryKeySelective(EvaluateReportManage record);

    int updateByPrimaryKeyWithBLOBs(EvaluateReportManage record);

    int updateByPrimaryKey(EvaluateReportManage record);
}