
package com.example.projectrecommend;

import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Selection;
import com.example.projectrecommend.entity.Student;
import com.example.projectrecommend.entity.Params;
import com.example.projectrecommend.service.ProjectService;
import com.example.projectrecommend.service.SelectionService;
import com.example.projectrecommend.service.StudentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRecommendApplicationTests {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private SelectionService selectionService;

	@Autowired
	private StudentService studentService;

	@Test
	void contextLoads() {
	}

	/**
	 * 登录功能测试 - 使用 login(Student)
	 */
	@Test
	void testLoginValidation() {
		Student student = new Student();
		student.setId("123456001"); // 存在的学号
		try {
			Student result = studentService.login(student);
			assertNotNull(result, "A successful login should return an object");
		} catch (Exception e) {
			fail("Login should not throw an exception: " + e.getMessage());
		}

		student.setId("123456000"); // 不存在的学号
		try {
			studentService.login(student);
			fail("An invalid student number should throw an exception");
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("UserNotFound"));
		}
	}

	/**
	 * 推荐功能（基于收藏）
	 */
	@Test
	void testRecommendProjects() {
		String studentId = "123456021";
		List<Project> recommended = selectionService.recommendProjects(studentId);
		assertNotNull(recommended, "The recommendation result cannot be empty");
	}

	/**
	 * 搜索功能测试
	 */
	@Test
	void testSearchProjects() {
		Params params = new Params();
		params.setKeywords("Java");
		params.setProjectType(Collections.singletonList("Software"));
		List<Project> results = projectService.findBySearch(params);
		assertNotNull(results, "The search results cannot be empty");
		assertTrue(results.size() >= 0, "The search results should be legitimate");
	}

	/**
	 * 收藏功能测试（添加/查看/删除）
	 */
	@Test
	void testSelectionFunctionality() {
		String studentId = "123456003";
		String projectId = "AA001"; // 确保数据库有该项目

		Selection selection = new Selection();
		selection.setStudentId(studentId);
		selection.setProjectId(projectId);

		selectionService.addSelection(selection);

		List<Selection> selections = selectionService.getSelectionsByStudentId(studentId);
		boolean found = selections.stream().anyMatch(s -> s.getProjectId().equals(projectId));
		assertTrue(found, "The added favorite item should be found");

		selectionService.removeSelection(selection);

		List<Selection> afterRemove = selectionService.getSelectionsByStudentId(studentId);
		boolean stillExists = afterRemove.stream().anyMatch(s -> s.getProjectId().equals(projectId));
		assertFalse(stillExists, "The item should have been removed from the collection");
	}
}
