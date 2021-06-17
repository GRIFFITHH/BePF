package com.tis1.bepf.project;

public class Project {
    Long id;
    String name;
    String stack;
    String region;

    public Project(Long id, String name, String stack, String region){
        this.id = id;
        this.name = name;
        this.stack = stack;
        this.region = region;
    }

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

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
