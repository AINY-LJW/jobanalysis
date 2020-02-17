package com.job.feign.provider.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.comment.common.intf.CompanySizeEnum;
import com.comment.common.intf.DegreerEnum;
import com.comment.common.intf.GenderEnum;
import com.comment.common.intf.SalaryEnum;
import com.comment.common.vo.ResumeVO;
import com.comment.common.vo.WorkExperienceVO;
import com.comment.util.EasyUIDataGridResult;
import com.comment.util.R;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.job.feign.provider.dao.ResumeMapper;
import com.job.feign.provider.domain.Resume;
import com.job.feign.provider.domain.ResumeExample;
import com.job.feign.provider.service.IResumeService;

/**
 * 
 * 简述部分:Service实现类
 * 
 *
 * @author lijiawen
 * @version 2020年1月18日
 */
@Service
public class ResumeServiceImpl implements IResumeService {
	@Autowired
	private ResumeMapper resumeMapper;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public R uploadResumeJson(String jsonObj) {
//		R r = R.ok();
		JSONArray jsonArray = null;
		try {
			jsonArray = JSON.parseArray(jsonObj);

			if (jsonArray != null) {
				Resume record = null;
				List<Resume> ResumeList = new ArrayList<>();
				for (Object j : jsonArray) {
					record = new Resume();
					JSONObject json = (JSONObject) j;
					// nid
					JSONObject nidJson = JSON.parseObject(json.getString("_id"));
					String nid = nidJson.getString("$oid");
					// 年龄
					Integer age = 0;
					try {
						age = Integer.parseInt(json.getString("age"));
					} catch (Exception e) {
						age = 0 ;
					}
					// 学历学位
					Integer degree = Integer.parseInt(json.getString("degree"));
					// 性别
					String genderString = json.getString("gender");
					Integer gender = GenderEnum.UNKNOW.getValue();
					if(!StringUtils.isEmpty(genderString)) {
						if(genderString.equals(GenderEnum.MAN.getTitle())){
							gender= GenderEnum.MAN.getValue();
						}else if (genderString.equals(GenderEnum.WOMAN.getTitle())) {
							gender= GenderEnum.WOMAN.getValue();
						}
					}
					// id
					String id = json.getString("id");
					// 所学专业
					String major = json.getString("major");
					// 工作经历
					String workExperienceList = json.getString("workExperienceList");
//					// 转换时间
//					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					SimpleDateFormat format1 = new SimpleDateFormat("MM dd, yyyy");
//					SimpleDateFormat format2 = new SimpleDateFormat("MM d, yyyy");
//					Long time = new Long(unixReviewTime) * 1000;
//					String d = format.format(time);
//					Date unixreviewtime = format.parse(d);
//
//					Date reviewtime;
//					try {
//						reviewtime = format1.parse(reviewTime);
//					} catch (Exception e) {
//						reviewtime = format2.parse(reviewTime);
//					}

					record.setNid(nid);
					record.setAge(age);
					record.setDegree(degree);
					record.setGender(gender);
					record.setId(id);
					record.setMajor(major);
					record.setWorkexperiencelist(workExperienceList);
					ResumeList.add(record);
				}
				int batchInsertResume = resumeMapper.batchInsertResume(ResumeList);
				return R.ok(new StringBuffer("成功").append(batchInsertResume).append("条，失败")
						.append(ResumeList.size() - batchInsertResume).append("条。").toString());
			} else {
				return R.error("json数据不能等于空");
			}
		} catch (Exception e) {
			logger.error("上传出错", e);
			throw new RuntimeException("上传出错", e);
		}
	}

	@Override
	public EasyUIDataGridResult getAllRsume(int pageNum, int pageSize) {
		PageMethod.startPage(pageNum, pageSize);
		ResumeExample example =new ResumeExample();
//		Criteria createCriteria = example.createCriteria();
//		List<Resume> allResumes = resumeMapper.selectByExample(example);
		List<Resume> allResumes = resumeMapper.selectByExampleWithBLOBs(example);
		List<ResumeVO> allResumesVo = new ArrayList<>();
		
		final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		allResumes.forEach(resume -> {
			ResumeVO resumeVO = new ResumeVO();
			BeanUtils.copyProperties(resume, resumeVO);
			JSONArray jsonArray = JSON.parseArray(resumeVO.getWorkexperiencelist().toString());
			if(jsonArray == null ) {return;}
			List<WorkExperienceVO> workExperienceList = new ArrayList<>();
			for (Object ob : jsonArray) {
				JSONObject json = (JSONObject) ob;
				String canSeeob = json.getString("canSee");
				if(canSeeob != null && Boolean.parseBoolean(canSeeob)) {
					//不可见					
					continue;
				}
				Date start_date = null;
				Date end_date = null;
				try {
					start_date = format.parse(json.getString("start_date"));
					String str = json.getString("end_date");
					if (str != null && !str.equals("至今") && !str.equals("今")) {
						end_date = format.parse(json.getString("end_date"));
					}
				} catch (ParseException e) {
					throw new RuntimeException("日期格式错误：",e);
				}
				Integer size = Integer.parseInt(json.getString("size"));
				String position_name = json.getString("position_name");
				String industry = json.getString("industry");
				Integer salary = Integer.parseInt(json.getString("salary"));
				String type = json.getString("type");
				String department = json.getString("department");
				
				WorkExperienceVO v = new WorkExperienceVO();
				//是否可见				
				v.setCanSee(canSeeob == null ? true : Boolean.parseBoolean(canSeeob));
				v.setEndDate(end_date);
				v.setIndustry(industry);
				v.setPosition_name(position_name);
				v.setSalary(SalaryEnum.getTitle(salary));
				v.setSize(CompanySizeEnum.getTitle(size));
				v.setStartDate(start_date);
				v.setType(type);
				v.setDepartment(department);
				workExperienceList.add(v);
			}
			resumeVO.setWorkExperienceListOb(workExperienceList);
			resumeVO.setDegree_title(DegreerEnum.getTitle(resumeVO.getDegree()));
			resumeVO.setGender_title(GenderEnum.getTitle(resumeVO.getGender()));
			allResumesVo.add(resumeVO);
		});
		EasyUIDataGridResult dataGridResult = new EasyUIDataGridResult();
		//总数		
		PageInfo<Resume> pageInfo = new PageInfo<>(allResumes);
		dataGridResult.setRows(allResumesVo);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}


}
