package com.example.projectrecommend.dao;

import com.example.projectrecommend.entity.Params;
import com.example.projectrecommend.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ProjectDao extends Mapper<Project> {

    List<Project> findBySearch(@Param("params") Params params);

    @Select("SELECT * FROM project")
    List<Project> getAllProjects();


    Project getProjectById(@Param("id") String id);

}
