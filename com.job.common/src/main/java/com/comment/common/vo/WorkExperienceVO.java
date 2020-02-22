package com.comment.common.vo;

import java.util.Date;
/**
 * 工作经历实体类
 * 简述部分:
 * @author lijiawen
 * @version 2020年1月18日
 */
public class WorkExperienceVO {
	private int num;//下标
	private Date startDate;
	private Date endDate;
	// 部门
	private String department;
	//公司规模	
	private String size;
	//职位
	private String position_name;
	//行业
	private String industry;
	//月薪
	private String salary;
	//类型	
	private String type;
	//是否可见  默认可见	
	private Boolean canSee;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getCanSee() {
		return canSee;
	}
	public void setCanSee(Boolean canSee) {
		this.canSee = canSee;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
