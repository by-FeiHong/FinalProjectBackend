package com.example.projectrecommend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;

    @Column(name = "project0")
    private String project0;

    @Column(name = "project1")
    private String project1;

    @Column(name = "project2")
    private String project2;

    @Column(name = "project3")
    private String project3;

    @Column(name = "project4")
    private String project4;

    @Column(name = "project5")
    private String project5;

    @Column(name = "project6")
    private String project6;

    @Column(name = "project7")
    private String project7;

    @Column(name = "project8")
    private String project8;

    @Column(name = "project9")
    private String project9;

    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject0() {
        return project0;
    }

    public void setProject0(String project0) {
        this.project0 = project0;
    }

    public String getProject1() {
        return project1;
    }

    public void setProject1(String project1) {
        this.project1 = project1;
    }

    public String getProject2() {
        return project2;
    }

    public void setProject2(String project2) {
        this.project2 = project2;
    }

    public String getProject3() {
        return project3;
    }

    public void setProject3(String project3) {
        this.project3 = project3;
    }

    public String getProject4() {
        return project4;
    }

    public void setProject4(String project4) {
        this.project4 = project4;
    }

    public String getProject5() {
        return project5;
    }

    public void setProject5(String project5) {
        this.project5 = project5;
    }

    public String getProject6() {
        return project6;
    }

    public void setProject6(String project6) {
        this.project6 = project6;
    }

    public String getProject7() {
        return project7;
    }

    public void setProject7(String project7) {
        this.project7 = project7;
    }

    public String getProject8() {
        return project8;
    }

    public void setProject8(String project8) {
        this.project8 = project8;
    }

    public String getProject9() {
        return project9;
    }

    public void setProject9(String project9) {
        this.project9 = project9;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}