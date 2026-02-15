package com.example.projectrecommend.service;

import com.example.projectrecommend.dao.ProjectDao;
import com.example.projectrecommend.dao.SelectionDao;
import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Selection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SelectionServiceImpl implements SelectionService {

    @Resource
    private SelectionDao selectionDao;

    @Resource
    private ProjectDao projectDao;


    @Override
    public void addSelection(Selection selection) {
        selectionDao.addSelection(selection);
    }

    @Override
    public void removeSelection(Selection selection) {
        selectionDao.removeSelection(selection);
    }

    @Override
    public void updateRank(List<Selection> selectionList) {
        for (Selection s : selectionList) {
            selectionDao.updateRank(s);
            System.out.println("updateRanking：" + s.getStudentId() + " - " + s.getProjectId() + " - " + s.getRanking());
        }
    }

    @Override
    public List<Selection> getSelectionsByStudentId(String studentId) {
        return selectionDao.getSelectionsByStudentId(studentId);
    }

    @Override
    public List<Project> getSelectedProjectsByStudentId(String studentId) {
        return selectionDao.getSelectedProjectsByStudentId(studentId);
    }

    @Override
    public boolean isSelected(String studentId, String projectId) {
        return selectionDao.isSelected(studentId, projectId) > 0;
    }

    @Override
    public List<Project> recommendProjects(String studentId) {
        // 1. 获取学生收藏的项目（已排序）
        List<Project> selectedProjects = selectionDao.getProjectsWithRankingByStudentId(studentId);
        if (selectedProjects.isEmpty()) return new ArrayList<>();

        // 2. 提取已收藏的 projectId
        List<String> selectedIds = selectedProjects.stream()
                .map(Project::getProjectId)
                .collect(Collectors.toList());

        // 3. 所有项目中排除已收藏的
        List<Project> candidates = projectDao.getAllProjects().stream()
                .filter(p -> !selectedIds.contains(p.getProjectId()))
                .collect(Collectors.toList());

        // 4. 构建偏好词权重
        Map<String, Integer> weights = new HashMap<>();
        for (int i = 0; i < selectedProjects.size(); i++) {
            Project p = selectedProjects.get(i);
            int score = 15 - i;
            weights.merge(p.getProjectType(), score, Integer::sum);
            weights.merge(p.getApplicationArea(), score, Integer::sum);
            weights.merge(p.getProjectNature(), score, Integer::sum);
        }

        // 5. 排序候选项目
        candidates.sort((a, b) -> {
            int scoreA = weights.getOrDefault(a.getProjectType(), 0)
                    + weights.getOrDefault(a.getApplicationArea(), 0)
                    + weights.getOrDefault(a.getProjectNature(), 0);
            int scoreB = weights.getOrDefault(b.getProjectType(), 0)
                    + weights.getOrDefault(b.getApplicationArea(), 0)
                    + weights.getOrDefault(b.getProjectNature(), 0);
            return Integer.compare(scoreB, scoreA);
        });

        return candidates.stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public List<Project> getSelectedProjectDetails(String studentId) {
        List<Selection> selections = selectionDao.getSelectionsByStudentId(studentId);
        if (selections.isEmpty()) return new ArrayList<>();

        List<Project> projects = new ArrayList<>();
        for (Selection sel : selections) {
            Project p = projectDao.getProjectById(sel.getProjectId());
            if (p != null) {
                p.setRanking(sel.getRanking()); // 这一步很重要
                projects.add(p);
            }
        }

        // 排序
        projects.sort(Comparator.comparingInt(p -> p.getRanking() != null ? p.getRanking() : Integer.MAX_VALUE));
        return projects;
    }




}
