package com.job.feign.provider.sqlpro;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


public class SqlProvider {
	public String getAllLike(Map<String, List<String>> map) {
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM("company_credit_archives as t");
		StringBuffer conditions = new StringBuffer("1=1");
		List<String> list = map.get("list");
		for (String string : list) {
			conditions.append(" AND ( t.legalPerson LIKE ").append("'%").append(string).append("%'");
			conditions.append(" OR t.industry LIKE ").append("'%").append(string).append("%'");
			conditions.append(" OR t.location LIKE ").append("'%").append(string).append("%'");
			conditions.append(" OR t.products LIKE ").append("'%").append(string).append("%')");
		}
		sql.WHERE(conditions.toString());
		return sql.toString();
	}
}
