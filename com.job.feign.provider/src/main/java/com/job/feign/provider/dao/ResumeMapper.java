package com.job.feign.provider.dao;

import com.job.feign.provider.domain.Resume;
import com.job.feign.provider.domain.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    int countByExample(ResumeExample example);

    int deleteByExample(ResumeExample example);

    int deleteByPrimaryKey(String nid);

    int insert(Resume record);

    int insertSelective(Resume record);

    List<Resume> selectByExampleWithBLOBs(ResumeExample example);

    List<Resume> selectByExample(ResumeExample example);

    Resume selectByPrimaryKey(String nid);

    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByExampleWithBLOBs(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKeyWithBLOBs(Resume record);

    int updateByPrimaryKey(Resume record);
    /**
     * 上传批处理
     * TODO
     * @param 
     * @return int
     */
    int batchInsertResume(List<Resume> ResumeList);
}