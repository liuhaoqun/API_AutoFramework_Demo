package com.qa.data;

/*
 * Create By ${liuhaoqun} on 2021/3/9.
 */

public class Users {
    private String name;
    private String job;

    public Users() {
        super();
    }

    public Users(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }

    //alt+shift+s//如何去生产getset方法
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
}
