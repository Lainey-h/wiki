package com.lainey.wiki.mapper;

import com.lainey.wiki.domain.All;
import com.lainey.wiki.domain.Main;
import com.lainey.wiki.domain.MainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainMapper {
    long countByExample(MainExample example);

    int deleteByExample(MainExample example);

    int deleteByPrimaryKey(Long albh);

    int insert(Main record);

    int insertSelective(Main record);

    List<Main> selectByExampleWithBLOBs(MainExample example);

    List<Main> selectByExample(MainExample example);

    All selectByPrimaryKey(Long albh);

    int updateByExampleSelective(@Param("record") Main record, @Param("example") MainExample example);

    int updateByExampleWithBLOBs(@Param("record") Main record, @Param("example") MainExample example);

    int updateByExample(@Param("record") Main record, @Param("example") MainExample example);

    int updateByPrimaryKeySelective(Main record);

    int updateByPrimaryKeyWithBLOBs(Main record);

    int updateByPrimaryKey(Main record);

    List<All> settAll();

    Long queryMaxAlbh();
}