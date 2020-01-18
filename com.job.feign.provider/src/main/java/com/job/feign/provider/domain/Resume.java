package com.job.feign.provider.domain;

public class Resume {
    private String nid;

    private Integer age;

    private Integer degree;

    private Integer gender;

    private String id;

    private String major;

    private byte[] workexperiencelist;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid == null ? null : nid.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public byte[] getWorkexperiencelist() {
        return workexperiencelist;
    }

    public void setWorkexperiencelist(byte[] workexperiencelist) {
        this.workexperiencelist = workexperiencelist;
    }
}