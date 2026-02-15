package com.example.projectrecommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan ("com.example.projectrecommend.dao")

public class ProjectRecommendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectRecommendApplication.class, args);
	}
}

