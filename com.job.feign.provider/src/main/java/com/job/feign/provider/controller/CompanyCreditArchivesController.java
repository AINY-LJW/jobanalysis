package com.job.feign.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.util.EasyUIDataGridResult;
import com.comment.util.R;
import com.job.feign.provider.service.ICompanyCreditArchivesService;
/**
 * 
 * 简述部分: 信誉档案
 *
 * @author WK
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
	@PostMapping("/getAllCompanyCredit")
	public EasyUIDataGridResult getResumeByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord) {
				return companyCreditArchivesService.getAllCompanyCreditCanSee(pageNum, pageSize,asin,reviewerName,keyWord);
		
	}
	
	/**
	 * 获取本公司信誉档案
	 * TODO
	 * @param 
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/getOwnCompanyCredit")
	public EasyUIDataGridResult getOwnCompanyCredit(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord,@RequestParam("companyId") int companyId) {
				return companyCreditArchivesService.getOwnCompanyCreditCanSee(pageNum, pageSize,companyId);
		
	}
	
	/**
	 * 更改档案状态
	 * TODO
	 * @param 
	 * @return R
	 */
	@PostMapping("/changeCompanyCrediState")
	public R changeCompanyCrediState(@RequestBody @RequestParam("id") int id,
			@RequestParam("state") boolean state) {
		try {
			int changeOwnCompanyCreditCanseeState = companyCreditArchivesService.changeOwnCompanyCreditCanseeState(id, state);
			if(changeOwnCompanyCreditCanseeState != 0) {			
				return R.ok();
			}else {
				return R.error("数据已变化");
			}
		} catch (Exception e) {
			return R.error("发生异常");
		}
		
	}
	
	/**
	 * 获取热门行业
	 * TODO
	 * @param 
	 * @return String
	 */
	@GetMapping("/getTextCloudJson")
	String getTextCloudJsonForIndustry() {
		try {
			return companyCreditArchivesService.getIndustryJson();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
