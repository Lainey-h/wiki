package com.lainey.wiki.mapper;

import com.lainey.wiki.domain.Jsjg;
import com.lainey.wiki.domain.JsjgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsjgMapper {
    long countByExample(JsjgExample example);

    int deleteByExample(JsjgExample example);

    int deleteByPrimaryKey(String albh);

    int insert(Jsjg record);

    int insertSelective(Jsjg record);

    List<Jsjg> selectByExampleWithBLOBs(JsjgExample example);

    List<Jsjg> selectByExample(JsjgExample example);

    Jsjg selectByPrimaryKey(String albh);

    int updateByExampleSelective(@Param("record") Jsjg record, @Param("example") JsjgExample example);

    int updateByExampleWithBLOBs(@Param("record") Jsjg record, @Param("example") JsjgExample example);

    int updateByExample(@Param("record") Jsjg record, @Param("example") JsjgExample example);

    int updateByPrimaryKeySelective(Jsjg record);

    int updateByPrimaryKeyWithBLOBs(Jsjg record);

    int updateByPrimaryKey(Jsjg record);
}