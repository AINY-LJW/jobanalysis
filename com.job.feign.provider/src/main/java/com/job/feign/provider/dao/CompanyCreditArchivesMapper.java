package com.job.feign.provider.dao;

import com.job.feign.provider.domain.CompanyCreditArchives;
import com.job.feign.provider.domain.CompanyCreditArchivesExample;
import com.job.feign.provider.domain.CompanyCreditArchivesVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
//    @Select("select t.* ,t2.name from company_credit_archives  t join company_user t2 on t2.id = t.cid where t.cansee = 1")
    @SelectProvider(type = CompanyCreditArchivesSqlProvider.class,method="getAll")
    List<CompanyCreditArchivesVO> selectAllCanSee(Map<String, String> map);
    
    /**
     * 更新状态
     * TODO
     * @param 
     * @return int
     */
    @Update("update company_credit_archives set cansee =#{cansee} where id = #{id}")
    int updateState(CompanyCreditArchives record);
    
    /**
     * 查询热门行业
     * TODO
     * @param 
     * @return List<String>
     */
    @Select("select industry from company_credit_archives limit 0 ,200;")
    List<String> getIndustry();
}