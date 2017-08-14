package com.liu.CatchYou.common.Basic.serialization;

import java.io.Serializable;

/**
 * Created by simon.liu on 2017/8/14.
 */
public class Student implements Serializable{
    private String name;
    private String age;
    private String gpa;

    public Student(String name, String age, String gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
}
