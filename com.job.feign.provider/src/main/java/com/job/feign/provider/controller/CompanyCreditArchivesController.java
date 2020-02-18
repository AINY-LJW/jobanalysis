package com.job.feign.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.util.EasyUIDataGridResult;
import com.job.feign.provider.service.ICompanyCreditArchivesService;
/**
 * 
 * 简述部分: 
 *
 * @author lijiawen
 * @version 2020年2月18日
 */
@RestController()
@RequestMapping("/companyCredit")
public class CompanyCreditArchivesController {
	@Autowired
	private ICompanyCreditArchivesService companyCreditArchivesService;
	/**
	 * 获取所有可见公司档案
	 * TODO
	 * @param 
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/getResumeByKeywords")
	public EasyUIDataGridResult getResumeByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
				return companyCreditArchivesService.getAllCompanyCreditCanSee(pageNum, pageSize);
		
	}
}
