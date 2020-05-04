package com.job.feign.provider.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.comment.util.EasyUIDataGridResult;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.job.feign.provider.dao.CompanyCreditArchivesMapper;
import com.job.feign.provider.dao.SeachHistoryMapper;
import com.job.feign.provider.domain.CompanyCreditArchives;
import com.job.feign.provider.domain.CompanyCreditArchivesExample;
import com.job.feign.provider.domain.CompanyCreditArchivesExample.Criteria;
import com.job.feign.provider.domain.CompanyCreditArchivesVO;
import com.job.feign.provider.domain.SeachHistory;
import com.job.feign.provider.service.ICompanyCreditArchivesService;

/**
 * 
 * 简述部分:企业信誉档案
 * 
 *
 * @author WK
 * @version 2020年2月18日
 */
@Service
public class CompanyCreditArchivesServiceImpl implements ICompanyCreditArchivesService {
	@Autowired
	private CompanyCreditArchivesMapper creditMapper;
	
	@Autowired
	private SeachHistoryMapper seachHistoryMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public EasyUIDataGridResult getAllCompanyCreditCanSee(int pageNum, int pageSize,String legalperson,String industry,String companyName,Integer uid) {
		try {
			PageMethod.startPage(pageNum, pageSize);
//			CompanyCreditArchivesExample example = new CompanyCreditArchivesExample();
//			Criteria createCriteria = example.createCriteria();
//			// 可见的		
//			createCriteria.andCanseeEqualTo(true);
//			List<CompanyCreditArchives> list = creditMapper.selectByExample(example);
			Map<String, String> map =new HashMap<>();
			map.put("legalperson", legalperson);
			map.put("industry", industry);
			map.put("companyName", companyName);
			List<CompanyCreditArchivesVO> list = creditMapper.selectAllCanSee(map);
			EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
			PageInfo<CompanyCreditArchivesVO> pageInfo = new PageInfo<>(list);
			dataGridResult.setRows(list);
			dataGridResult.setTotal(pageInfo.getTotal());
			
			saveSeachHistork(uid,legalperson,industry,companyName);
			return dataGridResult;
		} catch (Exception e) {
			logger.error("获取所有公司信誉档案异常", e);
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private void saveSeachHistork(Integer uid, String legalperson, String industry, String companyName) {
		if(uid == null) {
			// 企业用户
			return;
		}
		SeachHistory selectIfSeach = seachHistoryMapper.selectIfSeach(uid);
		SeachHistory seachHistory = new SeachHistory();
		seachHistory.setUid(uid);
		JSONObject json;
		if(selectIfSeach == null) {
			json =new JSONObject();
		}else {
			json = JSONObject.parseObject(selectIfSeach.getSeachKeys());
		}
		List<String> list = new ArrayList<String>();
		list.addAll((List<String>)json.get("seachkeys"));
		if(!StringUtils.isEmpty(legalperson)) {
			list.add(legalperson);
		}
		if(!StringUtils.isEmpty(industry)) {
			list.add(industry);
		}
		if(!StringUtils.isEmpty(companyName)) {
			list.add(companyName);
		}
		// 没搜索
		if(list.size() == 0) {
			return;
		}
		json.put("seachkeys", list);
		
		seachHistory.setSeachKeys(json.toString());
		// 搜索时保存搜索记录
		
		if (selectIfSeach == null) {
			seachHistoryMapper.insertSeachHistory(seachHistory);
		}else {
			seachHistory.setId(selectIfSeach.getId());
			seachHistoryMapper.updateSeachHistory(seachHistory);
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

	@Override
	public EasyUIDataGridResult getLikeCompanyCreditCanSee(int pageNum, int pageSize, String legalperson,
			String industry, String companyName,Integer uid) {
		// 获取关键词
		SeachHistory selectIfSeach = seachHistoryMapper.selectIfSeach(uid);
		if(selectIfSeach == null ) {
			return getAllCompanyCreditCanSee(pageNum, pageSize, legalperson, industry, companyName, uid);
		}else {
			PageMethod.startPage(pageNum, pageSize);
			CompanyCreditArchivesExample example = new CompanyCreditArchivesExample();
			
			String seachKeys = selectIfSeach.getSeachKeys();
			JSONObject parse = (JSONObject) JSONObject.parse(seachKeys);
			JSONArray object = (JSONArray) parse.get("seachkeys");
			List<String> listpara = new ArrayList<>();
			object.forEach(o -> {
				listpara.add((String)o);
			});
			Map<String, List<String>> map = new  HashMap<>();
			map.put("list", listpara);
			List<CompanyCreditArchives> list = creditMapper.getAllLike(map);
			EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
			PageInfo<CompanyCreditArchives> pageInfo = new PageInfo<>(list);
			dataGridResult.setRows(list);
			dataGridResult.setTotal(pageInfo.getTotal());
			return dataGridResult;
		}
	}

}
