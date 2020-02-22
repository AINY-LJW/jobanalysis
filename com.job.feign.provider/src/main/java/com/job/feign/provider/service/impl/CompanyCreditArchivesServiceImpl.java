package com.job.feign.provider.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.comment.util.EasyUIDataGridResult;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.job.feign.provider.dao.CompanyCreditArchivesMapper;
import com.job.feign.provider.domain.CompanyCreditArchives;
import com.job.feign.provider.domain.CompanyCreditArchivesExample;
import com.job.feign.provider.domain.CompanyCreditArchivesExample.Criteria;
import com.job.feign.provider.domain.CompanyCreditArchivesVO;
import com.job.feign.provider.service.ICompanyCreditArchivesService;

/**
 * 
 * 简述部分:企业信誉档案
 * 
 * Copyright: 版权所有 (c) JOIN-CHEER Company: 久其
 *
 * @author lijiawen
 * @version 2020年2月18日
 */
@Service
public class CompanyCreditArchivesServiceImpl implements ICompanyCreditArchivesService {
	@Autowired
	private CompanyCreditArchivesMapper creditMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public EasyUIDataGridResult getAllCompanyCreditCanSee(int pageNum, int pageSize) {
		try {
			PageMethod.startPage(pageNum, pageSize);
//			CompanyCreditArchivesExample example = new CompanyCreditArchivesExample();
//			Criteria createCriteria = example.createCriteria();
//			// 可见的		
//			createCriteria.andCanseeEqualTo(true);
//			List<CompanyCreditArchives> list = creditMapper.selectByExample(example);
			List<CompanyCreditArchivesVO> list = creditMapper.selectAllCanSee();
			EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
			PageInfo<CompanyCreditArchivesVO> pageInfo = new PageInfo<>(list);
			dataGridResult.setRows(list);
			dataGridResult.setTotal(pageInfo.getTotal());
			return dataGridResult;
		} catch (Exception e) {
			logger.error("获取所有公司信誉档案异常", e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EasyUIDataGridResult getOwnCompanyCreditCanSee(int pageNum, int pageSize,int companyId) {
		try {
			PageMethod.startPage(pageNum, pageSize);
			CompanyCreditArchivesExample example = new CompanyCreditArchivesExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andCidEqualTo(companyId);
			List<CompanyCreditArchives> list = creditMapper.selectByExample(example);
			EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
			PageInfo<CompanyCreditArchives> pageInfo = new PageInfo<>(list);
			dataGridResult.setRows(list);
			dataGridResult.setTotal(pageInfo.getTotal());
			return dataGridResult;
		} catch (Exception e) {
			logger.error("获取本公司信誉档案异常", e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int changeOwnCompanyCreditCanseeState(int id, boolean cansee) {
		CompanyCreditArchives record =new CompanyCreditArchives();
		record.setId(id);
		record.setCansee(cansee);
		return creditMapper.updateState(record);
	}

	@Override
	public String getIndustryJson() {
		JSONArray json = new JSONArray();
		JSONObject o = null;
		List<String> industry = creditMapper.getIndustry();
		for (String string : industry) {
			o = new JSONObject();
			o.put("name",string);
			// 随机大小
			o.put("value",Math.random()*100);
			json.add(o);
		}
		return json.toString();
	}

}
