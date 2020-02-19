package com.job.feign.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * 简述部分:简历
 *
 * @author lijiawen
 * @version 2020年1月18日
 */

import com.comment.util.EasyUIDataGridResult;
import com.comment.util.R;
import com.job.feign.consumer.feign.UserFeignClient;
@RestController()
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private UserFeignClient resumeFeignClient;
	/**
	 * 上传简历
	 * @param 
	 * @return String
	 */
	@PostMapping(value = "/upload")
	public R uploadJson(@RequestBody(required = false) @RequestParam("jsonObj") String jsonObj) {
		return resumeFeignClient.uploadJson(jsonObj);
	}
	
	/**
	 * 根据关键词查找评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@RequestMapping(value = "getResumeByKeywords", method = RequestMethod.POST)
	public EasyUIDataGridResult getCommentsByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
		EasyUIDataGridResult commentList = resumeFeignClient.getResumeByKeywords(pageNum, pageSize, asin, reviewerName, keyWord);
		return commentList;
	}
}
