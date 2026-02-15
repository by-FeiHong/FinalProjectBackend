package com.example.projectrecommend.service;

import com.example.projectrecommend.dao.StudentDao;
import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Student;
import com.example.projectrecommend.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 学生登录
     * @param student 学生对象，包含 id
     * @return 登录成功的学生对象
     * @throws CustomException 用户参数为空或用户不存在
     */
    public Student login(Student student) {
        if (student.getId() == null || student.getId().trim().isEmpty()) {
            throw new CustomException("UserLoginParaError");
        }
        Student user = studentDao.findById(student.getId());
        if (user == null) {
            throw new CustomException("UserNotFound");
        }
        return user;
    }

    /**
     * 根据学生 ID 查询该学生关联的所有项目
     * @param studentId 学生 ID
     * @return 学生关联的 Project 列表
     * @throws CustomException 学生 ID 为空或学生没有关联的项目
     */
    public List<Project> getStudentProjects(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new CustomException("StudentIdEmpty");
        }
        List<Project> projects = studentDao.findStudentProjects(studentId);
        if (projects == null || projects.isEmpty()) {
            throw new CustomException("The student has no associated projects");
        }
        return projects;
    }
}