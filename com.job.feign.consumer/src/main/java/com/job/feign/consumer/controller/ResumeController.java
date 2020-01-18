package com.job.feign.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * 简述部分:简历
 *
 * @author lijiawen
 * @version 2020年1月18日
 */

import com.comment.util.R;
import com.job.feign.consumer.feign.ResumeFeignClient;
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
}
