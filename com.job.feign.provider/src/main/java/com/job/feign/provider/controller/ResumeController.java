package com.job.feign.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comment.util.R;
import com.job.feign.provider.service.IResumeService;

/**
 * 
 * 简述部分: 简历
 * @author lijiawen
 * @version 2020年1月18日
 */
@RestController()
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private IResumeService iResumeService;
	/**
	 * 上传简历
	 * @param 
	 * @return String
	 */
	@PostMapping(value = "/upload")
	public R uploadJson(@RequestBody(required = false) @RequestParam("jsonObj") String jsonObj) {
		
		try {
			return iResumeService.uploadResumeJson(jsonObj);
		} catch (Exception e) {
			return R.error("上传错误，请联系管理员");
		}
		
	}
}
