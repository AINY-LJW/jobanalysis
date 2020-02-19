package com.job.feign.consumer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.common.domain.User;
import com.comment.util.EasyUIDataGridResult;
import com.job.feign.consumer.feign.UserFeignClient;
/**
 * 
 * 简述部分:公司信誉档案接口
 *
 * @author lijiawen
 * @version 2020年2月18日
 */
@RestController
@RequestMapping("/companyCredit")
public class CompanyCreditArchivesController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserFeignClient feignClient;
	@PostMapping("/getAllCompanyCredit")
	public EasyUIDataGridResult getAllCompanyCredit(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
		return feignClient.getAllCompanyCredit(pageNum, pageSize, asin, reviewerName, keyWord);
	}
	@PostMapping("/getOwnCompanyCredit")
	public EasyUIDataGridResult getOwnCompanyCredit(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser == null) {
			throw new RuntimeException("登录国企，请重新登陆");
		}
		// 身份		
		String identity = (String) request.getSession().getAttribute("identity");
		if (!"company".equals(identity)) {
			throw new RuntimeException("当前登录用户不是也起用户");
		}
		return feignClient.getOwnCompanyCredit(pageNum, pageSize, asin, reviewerName, keyWord, loginUser.getId());
	}
}
