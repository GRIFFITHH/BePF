package com.tis1.bepf.member;


public class Member {

    private Long id;
    private String name;
    private String job;
    private Integer password; // 패스워드는 Integer? Number?//



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String toString(){
        return "Name" + name +", Job "+ job;
    }

}
