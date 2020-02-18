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
}
