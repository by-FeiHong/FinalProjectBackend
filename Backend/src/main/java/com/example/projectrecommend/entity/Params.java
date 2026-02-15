package com.example.projectrecommend.entity;

import java.util.List;

public class Params {
    private String supervisorName;
    private String projectTitle;
    private String keywords;
    private String projectDescription;
    private List<String> projectType;
    private List<String> applicationArea;
    private List<String> projectNature;

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<String> getProjectType() {
        return projectType;
    }

    public void setProjectType(List<String> projectType) {
        this.projectType = projectType;
    }


    public List<String> getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(List<String> applicationArea) {
        this.applicationArea = applicationArea;
    }

    public List<String> getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(List<String> projectNature) {
        this.projectNature = projectNature;
    }



}
