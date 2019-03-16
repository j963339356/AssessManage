package com.wjc.assess.dao;

import com.wjc.assess.entity.Totaltime;
import com.wjc.assess.entity.TotaltimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotaltimeMapper {
    int countByExample(TotaltimeExample example);

    int deleteByExample(TotaltimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Totaltime record);

    int insertSelective(Totaltime record);

    List<Totaltime> selectByExample(TotaltimeExample example);

    Totaltime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Totaltime record, @Param("example") TotaltimeExample example);

    int updateByExample(@Param("record") Totaltime record, @Param("example") TotaltimeExample example);

    int updateByPrimaryKeySelective(Totaltime record);

    int updateByPrimaryKey(Totaltime record);
}