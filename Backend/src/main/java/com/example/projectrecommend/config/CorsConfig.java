package com.example.projectrecommend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8081"); // 允许前端域名
        config.addAllowedMethod("*"); // 允许所有 HTTP 方法（GET, POST, PUT, DELETE 等）
        config.addAllowedHeader("*"); // 允许所有请求头
        config.setAllowCredentials(true); // 允许携带凭证（如 Cookie、Authorization 头）

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 应用到所有路径
        return new CorsFilter(source);
    }
}