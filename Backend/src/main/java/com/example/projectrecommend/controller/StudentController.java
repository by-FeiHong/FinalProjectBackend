package com.example.projectrecommend.controller;

import com.auth0.jwt.JWTVerifier;
import com.example.projectrecommend.common.Result;
import com.example.projectrecommend.entity.Project;
import com.example.projectrecommend.entity.Student;
import com.example.projectrecommend.exception.CustomException;
import com.example.projectrecommend.service.StudentService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:8081")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private static final String SECRET_KEY = "your-secret-key"; // 确保与前端一致
    private static final long EXPIRATION_TIME = 3600000; // 1小时过期（毫秒）

    @PostMapping("/login")
    public Result<Student> login(@RequestBody Student student) {
        try {
            Student user = studentService.login(student);
            if (user == null) {
                return Result.error("Invalid credentials");
            }


            String token = JWT.create()
                    .withSubject(user.getId())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC256(SECRET_KEY)); //HMAC256

            user.setToken(token);
            return Result.success(user); // token
        } catch (CustomException e) {
            return Result.error(e.getMessage());
        } catch (Exception e) {
            return Result.error("Login failed: " + e.getMessage());
        }
    }

    @GetMapping("/projects/{studentId}")
    public Result<List<Project>> getStudentProjects(@PathVariable String studentId, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                return Result.error("No token provided");
            }

            try {
                String jwtToken = token.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("your-secret-key");
                JWTVerifier verifier = JWT.require(algorithm).build();
                String tokenStudentId = verifier.verify(jwtToken).getSubject();
                if (!studentId.equals(tokenStudentId)) {
                    return Result.error("Invalid token");
                }
            } catch (JWTVerificationException e) {
                return Result.error("Invalid token");
            }

            List<Project> projects = studentService.getStudentProjects(studentId);
            return Result.success(projects);
        } catch (CustomException e) {
            return Result.error(e.getMessage());
        }
    }
}