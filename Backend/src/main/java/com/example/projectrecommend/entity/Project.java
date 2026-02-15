package com.example.projectrecommend.entity;


import javax.persistence.*;

@Table(name = "project")
public class Project {

    private Long indexNumber;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String projectId;  // 项目的 ID

    private String supervisorName;  // 导师名称

    private String email;

    private String projectTitle;  // 项目标题

    private String projectType;  // 项目类型

    private String applicationArea;  // 应用领域

    private String projectNature;  // 项目性质

    private String keywords;  // 关键词

    private String projectDescription;  // 项目描述

    private String mainTask1;  // 主要任务 1

    private String mainTask2;  // 主要任务 2

    private String mainTask3;  // 主要任务 3

    private String mainTask4;  // 主要任务 4

    private String outcome1;  // 项目成果 1

    private String outcome2;  // 项目成果 2

    private String outcome3;  // 项目成果 3

    private String skillsRequired;  // 所需技能

    private String resourcesRequired;  // 所需资源

    private String howChallenging;  // 挑战程度

    public Long getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Long indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getApplicationArea() {
        return applicationArea;
    }

    public void setApplicationArea(String applicationArea) {
        this.applicationArea = applicationArea;
    }

    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature;
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

    public String getMainTask1() {
        return mainTask1;
    }

    public void setMainTask1(String mainTask1) {
        this.mainTask1 = mainTask1;
    }

    public String getMainTask2() {
        return mainTask2;
    }

    public void setMainTask2(String mainTask2) {
        this.mainTask2 = mainTask2;
    }

    public String getMainTask3() {
        return mainTask3;
    }

    public void setMainTask3(String mainTask3) {
        this.mainTask3 = mainTask3;
    }

    public String getMainTask4() {
        return mainTask4;
    }

    public void setMainTask4(String mainTask4) {
        this.mainTask4 = mainTask4;
    }

    public String getOutcome1() {
        return outcome1;
    }

    public void setOutcome1(String outcome1) {
        this.outcome1 = outcome1;
    }

    public String getOutcome2() {
        return outcome2;
    }

    public void setOutcome2(String outcome2) {
        this.outcome2 = outcome2;
    }

    public String getOutcome3() {
        return outcome3;
    }

    public void setOutcome3(String outcome3) {
        this.outcome3 = outcome3;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public String getResourcesRequired() {
        return resourcesRequired;
    }

    public void setResourcesRequired(String resourcesRequired) {
        this.resourcesRequired = resourcesRequired;
    }

    public String getHowChallenging() {
        return howChallenging;
    }

    public void setHowChallenging(String howChallenging) {
        this.howChallenging = howChallenging;
    }

    @Transient
    private Integer ranking;

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

}