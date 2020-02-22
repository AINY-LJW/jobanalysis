package com.job.feign.provider.dao;

import java.util.Map;

import com.alibaba.druid.util.StringUtils;
/**
 * 
 * 简述部分:sql 提供器
 *
 * @author WK
 * @version 2020年2月22日
 */
public class CompanyCreditArchivesSqlProvider {
	public String getAll(Map<String, String> map) {
		StringBuffer sb=new StringBuffer()
				.append("select t.* ,t2.name from company_credit_archives  t join company_user t2 on t2.id = t.cid where t.cansee = 1 \r\n");
		if(!StringUtils.isEmpty(map.get("legalperson"))) {
			sb.append("and t.legalperson like  concat('%',#{legalperson},'%')  \r\n");
		}
		if(!StringUtils.isEmpty((map.get("industry")))) {
			sb.append("and t.industry like concat('%',#{industry},'%')  \r\n")	;
		}
		if(!StringUtils.isEmpty((map.get("companyName")))) {
			sb.append("and t2.name like concat('%',#{companyName},'%') \r\n");
		}
		return sb.toString();
		
	}
}
