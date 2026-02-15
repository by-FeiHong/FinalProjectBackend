package com.example.projectrecommend.service;

import com.example.projectrecommend.dao.ProjectDao;
import com.example.projectrecommend.entity.Params;
import com.example.projectrecommend.entity.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectService {

    @Resource
    private ProjectDao projectDao;

    public List<Project> getProject() {
         return projectDao.selectAll();
    }

    public List<Project> findBySearch(Params params) {

        return projectDao.findBySearch(params);
    }

}
