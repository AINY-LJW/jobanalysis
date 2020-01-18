package com.comment.common.domain;

public class Resume {
    private String nid;

    private Integer age;

    private Integer degree;

    private Integer gender;

    private String id;

    private String major;

    private String password;

    private String workexperiencelist;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWorkexperiencelist() {
        return workexperiencelist;
    }

    public void setWorkexperiencelist(String workexperiencelist) {
        this.workexperiencelist = workexperiencelist == null ? null : workexperiencelist.trim();
    }
}