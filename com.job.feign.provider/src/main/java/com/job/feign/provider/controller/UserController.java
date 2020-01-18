package com.job.feign.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.feign.provider.dao.UserMapper;
import com.job.feign.provider.domain.User;
import com.job.feign.provider.domain.UserExample;
import com.job.feign.provider.domain.UserExample.Criteria;

/**
 * 
 * 简述部分:用户
 *
 * @author lijiawen
 * @version 2020年1月17日
 */
@RestController
public class UserController {
	@Autowired
	private UserMapper mapper;
	@PostMapping(value = "/user/loginForm")
	 public User ifUserExist(@RequestBody @RequestParam("form-username") String name,@RequestParam("form-password") String pwd) {
		UserExample example=new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPhoneNumberEqualTo(name);
		createCriteria.andPasswordEqualTo(pwd);
		List<User> selectByExample = mapper.selectByExample(example);
		if(selectByExample.size()!=0) {
			return selectByExample.get(0);
		}else {
			return null;
		}
	}
}
