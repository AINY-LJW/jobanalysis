package com.job.feign.provider.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 
 * 简述部分: 企业档案搜索记录
 * @author WK
 * @version 2020年4月19日
 */
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.job.feign.provider.domain.SeachHistory;
@Mapper
public interface SeachHistoryMapper {
	/**
	 * 查看是否有搜索记录
	 * TODO
	 * @param 
	 * @return int
	 */
	@Select("SELECT * FROM seach_history t where t.UID = #{userid}")
	SeachHistory selectIfSeach(@Param("userid")int userid);
	/**
	 * 插入搜索记录
	 * TODO
	 * @param 
	 * @return void
	 */
	@Insert("INSERT INTO seach_history(uid,seachKeys) VALUES(#{uid},#{seachKeys})")
	void insertSeachHistory(SeachHistory seachHistory);
	
	/**
	 * 更新搜索记录
	 * TODO
	 * @param 
	 * @return void
	 */
	@Update("UPDATE seach_history t SET seachKeys = #{seachKeys} where t.id = #{id}")
	void updateSeachHistory(SeachHistory seachHistory);
}
