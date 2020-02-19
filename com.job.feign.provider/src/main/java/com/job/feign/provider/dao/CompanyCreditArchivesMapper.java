package com.job.feign.provider.dao;

import com.job.feign.provider.domain.CompanyCreditArchives;
import com.job.feign.provider.domain.CompanyCreditArchivesExample;
import com.job.feign.provider.domain.CompanyCreditArchivesVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    
    /**
     * 获取所有可见公司档案
     * TODO
     * @param 
     * @return List<CompanyCreditArchives>
     */
    @Select("select t.* ,t2.name from company_credit_archives  t join company_user t2 on t2.id = t.cid where t.cansee = 1")
    List<CompanyCreditArchivesVO> selectAllCanSee();
}