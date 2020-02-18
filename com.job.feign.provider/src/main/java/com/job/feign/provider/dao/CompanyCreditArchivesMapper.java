package com.job.feign.provider.dao;

import com.job.feign.provider.domain.CompanyCreditArchives;
import com.job.feign.provider.domain.CompanyCreditArchivesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyCreditArchivesMapper {
    int countByExample(CompanyCreditArchivesExample example);

    int deleteByExample(CompanyCreditArchivesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyCreditArchives record);

    int insertSelective(CompanyCreditArchives record);

    List<CompanyCreditArchives> selectByExample(CompanyCreditArchivesExample example);

    CompanyCreditArchives selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyCreditArchives record, @Param("example") CompanyCreditArchivesExample example);

    int updateByExample(@Param("record") CompanyCreditArchives record, @Param("example") CompanyCreditArchivesExample example);

    int updateByPrimaryKeySelective(CompanyCreditArchives record);

    int updateByPrimaryKey(CompanyCreditArchives record);
}