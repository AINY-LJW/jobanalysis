package com.job.feign.provider.service;


import com.comment.util.EasyUIDataGridResult;
import com.comment.util.R;

/**
 * 
 * 简述部分:简历Service
 *
 * @author WK
 * @version 2020年1月18日
 */
public interface IResumeService {
	/**
	 * 上传
	 * TODO
	 * @param 
	 * @return R
	 */
	public R uploadResumeJson(String jsonObj);
	/**
	 * 获取所有
	 * TODO
	 * @param 
	 * @return R
	 */
	public EasyUIDataGridResult getAllRsume(int pageNum, int pageSize,String identity,String major);
	
	/**
	 * 更改状态
	 * TODO
	 * @param 
	 * @return int
	 */
	public int changeState(String id, int index);
	
}
