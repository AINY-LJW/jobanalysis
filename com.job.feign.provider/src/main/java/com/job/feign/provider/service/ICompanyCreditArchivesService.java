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
}
