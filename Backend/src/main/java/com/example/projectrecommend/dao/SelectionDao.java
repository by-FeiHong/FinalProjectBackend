package com.example.projectrecommend.dao;

import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Selection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectionDao {
    int addSelection(Selection selection);
    int removeSelection(Selection selection);
    List<Selection> getSelectionsByStudentId(String studentId);
    int isSelected(String studentId, String projectId);
    void updateRank(Selection selection);
    List<Project> getSelectedProjectsByStudentId(String studentId);  // 用于推荐
    List<Project> getProjectsWithRankingByStudentId(String studentId);


}
