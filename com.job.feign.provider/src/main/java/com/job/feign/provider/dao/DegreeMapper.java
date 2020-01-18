package com.job.feign.provider.dao;

import com.job.feign.provider.domain.Degree;
import com.job.feign.provider.domain.DegreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DegreeMapper {
    int countByExample(DegreeExample example);

    int deleteByExample(DegreeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Degree record);

    int insertSelective(Degree record);

    List<Degree> selectByExample(DegreeExample example);

    Degree selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Degree record, @Param("example") DegreeExample example);

    int updateByExample(@Param("record") Degree record, @Param("example") DegreeExample example);

    int updateByPrimaryKeySelective(Degree record);

    int updateByPrimaryKey(Degree record);
}