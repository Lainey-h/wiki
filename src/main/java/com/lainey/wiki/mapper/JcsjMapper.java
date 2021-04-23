package com.lainey.wiki.mapper;

import com.lainey.wiki.domain.Jcsj;
import com.lainey.wiki.domain.JcsjExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JcsjMapper {
    long countByExample(JcsjExample example);

    int deleteByExample(JcsjExample example);

    int deleteByPrimaryKey(Long albh);

    int insert(Jcsj record);

    int insertSelective(Jcsj record);

    List<Jcsj> selectByExampleWithBLOBs(JcsjExample example);

    List<Jcsj> selectByExample(JcsjExample example);

    Jcsj selectByPrimaryKey(Long albh);

    int updateByExampleSelective(@Param("record") Jcsj record, @Param("example") JcsjExample example);

    int updateByExampleWithBLOBs(@Param("record") Jcsj record, @Param("example") JcsjExample example);

    int updateByExample(@Param("record") Jcsj record, @Param("example") JcsjExample example);

    int updateByPrimaryKeySelective(Jcsj record);

    int updateByPrimaryKeyWithBLOBs(Jcsj record);

    int updateByPrimaryKey(Jcsj record);
}