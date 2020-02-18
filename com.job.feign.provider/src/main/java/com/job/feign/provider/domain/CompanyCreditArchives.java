package com.job.feign.provider.domain;

public class CompanyCreditArchives {
    private Integer id;

    private Integer cid;

    private String grade;

    private String legalperson;

    private Integer registeredcapital;

    private String industry;

    private Integer phone;

    private String location;

    private String products;

    private String introduction;

    private Boolean cansee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    public Integer getRegisteredcapital() {
        return registeredcapital;
    }

    public void setRegisteredcapital(Integer registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products == null ? null : products.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Boolean getCansee() {
        return cansee;
    }

    public void setCansee(Boolean cansee) {
        this.cansee = cansee;
    }
}