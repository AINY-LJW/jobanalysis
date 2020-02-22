package com.job.feign.provider.service;

import com.comment.util.EasyUIDataGridResult;

public interface ICompanyCreditArchivesService {
	/**
	 * 获取所有
	 * TODO
	 * @param 
	 * @return R
	 */
	public EasyUIDataGridResult getAllCompanyCreditCanSee(int pageNum, int pageSize);
	
	/**
	 * 本公司信誉档案
	 * TODO
	 * @param 
	 * @return EasyUIDataGridResult
	 */
	public EasyUIDataGridResult getOwnCompanyCreditCanSee(int pageNum, int pageSize,int companyId);
	
	/**
	 * 改变状态  公开 不公开
	 * TODO
	 * @param 
	 * @return R
	 */
	public int changeOwnCompanyCreditCanseeState(int id,boolean state);
	
	
	/**
	 * 获取热门行业
	 * TODO
	 * @param 
	 * @return String
	 */
	public String getIndustryJson();
}
