package com.lainey.wiki.mapper;

import com.lainey.wiki.domain.Fszz;
import com.lainey.wiki.domain.FszzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FszzMapper {
    long countByExample(FszzExample example);

    int deleteByExample(FszzExample example);

    int deleteByPrimaryKey(String albh);

    int insert(Fszz record);

    int insertSelective(Fszz record);

    List<Fszz> selectByExampleWithBLOBs(FszzExample example);

    List<Fszz> selectByExample(FszzExample example);

    Fszz selectByPrimaryKey(String albh);

    int updateByExampleSelective(@Param("record") Fszz record, @Param("example") FszzExample example);

    int updateByExampleWithBLOBs(@Param("record") Fszz record, @Param("example") FszzExample example);

    int updateByExample(@Param("record") Fszz record, @Param("example") FszzExample example);

    int updateByPrimaryKeySelective(Fszz record);

    int updateByPrimaryKeyWithBLOBs(Fszz record);

    int updateByPrimaryKey(Fszz record);
}