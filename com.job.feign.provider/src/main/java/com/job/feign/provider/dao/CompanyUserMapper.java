package com.job.feign.provider.dao;

import com.job.feign.provider.domain.CompanyUser;
import com.job.feign.provider.domain.CompanyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyUserMapper {
    int countByExample(CompanyUserExample example);

    int deleteByExample(CompanyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyUser record);

    int insertSelective(CompanyUser record);

    List<CompanyUser> selectByExample(CompanyUserExample example);

    CompanyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyUser record, @Param("example") CompanyUserExample example);

    int updateByExample(@Param("record") CompanyUser record, @Param("example") CompanyUserExample example);

    int updateByPrimaryKeySelective(CompanyUser record);

    int updateByPrimaryKey(CompanyUser record);
}