package com.comment.common.vo;

import java.util.List;

import com.comment.common.domain.Resume;

/**
 * 
 * 简述部分:
 *
 * @author lijiawen
 * @version 2020年1月18日
 */
public class ResumeVO extends Resume{
	private String gender_title;
	private String degree_title;
	/**
	 * 工作经历
	 */
	private List<WorkExperienceVO> workExperienceListOb;

	public List<WorkExperienceVO> getWorkExperienceListOb() {
		return workExperienceListOb;
	}

	public void setWorkExperienceListOb(List<WorkExperienceVO> workExperienceListOb) {
		this.workExperienceListOb = workExperienceListOb;
	}

	public String getGender_title() {
		return gender_title;
	}

	public void setGender_title(String gender_title) {
		this.gender_title = gender_title;
	}

	public String getDegree_title() {
		return degree_title;
	}

	public void setDegree_title(String degree_title) {
		this.degree_title = degree_title;
	}
	
	
}
