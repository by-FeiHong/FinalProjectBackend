package com.example.projectrecommend.controller;

import com.example.projectrecommend.common.Result;
import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Selection;
import com.example.projectrecommend.service.SelectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/selection")
public class SelectionController {

    @Resource
    private SelectionService selectionService;

    @PostMapping("/add")
    public Result<?> addSelection(@RequestParam String studentId, @RequestParam String projectId) {
        Selection s = new Selection();
        s.setStudentId(studentId);
        s.setProjectId(projectId);
        s.setRanking(0); // 默认 0，可选
        selectionService.addSelection(s);
        return Result.success("Successful Selection ");
    }

    @PostMapping("/remove")
    public Result<?> removeSelection(@RequestParam String studentId, @RequestParam String projectId) {
        Selection s = new Selection();
        s.setStudentId(studentId);
        s.setProjectId(projectId);
        selectionService.removeSelection(s);
        return Result.success("Delete successfully");
    }

    @GetMapping("/student/{studentId}")
    public Result getSelections(@PathVariable String studentId) {
        List<Project> selectedProjects = selectionService.getSelectedProjectDetails(studentId);
        return Result.success(selectedProjects);
    }

    @PostMapping("/ranking")
    public Result<?> updateRank(@RequestBody List<Selection> selectionList) {
        for (Selection s : selectionList) {
            System.out.println("Data" + s);
        }
        selectionService.updateRank(selectionList);
        return Result.success("Update successfully");
    }

    // SelectionController.java

    @GetMapping("/recommend/{studentId}")
    public Result<List<Project>> getRecommendations(@PathVariable String studentId) {
        List<Project> recommendations = selectionService.recommendProjects(studentId);
        return Result.success(recommendations);
    }

}
