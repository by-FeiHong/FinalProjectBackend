package com.example.projectrecommend.service;

import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Selection;

import java.util.List;

public interface SelectionService {
    void addSelection(Selection selection);
    void removeSelection(Selection selection);
    void updateRank(List<Selection> selectionList);
    List<Selection> getSelectionsByStudentId(String studentId);
    boolean isSelected(String studentId, String projectId);
    List<Project> recommendProjects(String studentId);
    List<Project> getSelectedProjectDetails(String studentId);
    List<Project> getSelectedProjectsByStudentId(String studentId);

}
