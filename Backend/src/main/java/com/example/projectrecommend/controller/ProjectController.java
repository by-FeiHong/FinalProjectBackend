package com.example.projectrecommend.controller;

import com.example.projectrecommend.common.Result;
import com.example.projectrecommend.entity.Params;
import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Result<List<Project>> getProject() {
        List<Project> list = projectService.getProject();
        return Result.success(list, list.size());
    }

    @GetMapping("/search")
    public Result<List<Project>> findBySearch(
            @RequestParam(required = false) String supervisorName,
            @RequestParam(required = false) String projectTitle,
            @RequestParam(required = false) String keywords,
            @RequestParam(required = false) String projectDescription,
            @RequestParam(required = false) String projectType,
            @RequestParam(required = false) String applicationArea,
            @RequestParam(required = false) String projectNature) { // 新增 projectType 参数
        // 创建 Params 对象并设置查询参数
        Params params = new Params();
        params.setSupervisorName(supervisorName);
        params.setProjectTitle(projectTitle);
        params.setKeywords(keywords);
        params.setProjectDescription(projectDescription);

        // 处理 projectType：将逗号分隔的字符串转为 List
        if (projectType != null && !projectType.isEmpty()) {
            List<String> projectTypeList = Arrays.asList(projectType.split(","));
            params.setProjectType(projectTypeList);
        } else {
            params.setProjectType(Collections.emptyList()); // 空列表表示无过滤条件
        }
        if (applicationArea != null && !applicationArea.isEmpty()) {
            List<String> applicationAreaList = Arrays.asList(applicationArea.split(","));
            params.setApplicationArea(applicationAreaList);
        } else {
            params.setApplicationArea(Collections.emptyList()); // 空列表表示无过滤条件
        }
        if (projectNature != null && !projectNature.isEmpty()) {
            List<String> projectNatureList = Arrays.asList(projectNature.split(","));
            params.setProjectNature(projectNatureList);
        } else {
            params.setProjectNature(Collections.emptyList()); // 空列表表示无过滤条件
        }

        List<Project> list = projectService.findBySearch(params);
        return Result.success(list, list.size());
    }
}