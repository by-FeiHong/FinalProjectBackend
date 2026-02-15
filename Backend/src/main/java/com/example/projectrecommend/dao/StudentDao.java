package com.example.projectrecommend.dao;

import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StudentDao extends Mapper<Student> {

    /**
     * 根据学生 ID 查询学生记录
     * @param id 学生 ID
     * @return 学生对象
     */
    @Select("select * from student where id = #{id}")
    Student findById(@Param("id") String id);

    /**
     * 根据学生 ID 查询该学生关联的所有项目
     * @param studentId 学生 ID
     * @return 学生关联的 Project 列表
     */
    List<Project> findStudentProjects(@Param("studentId") String studentId);
}