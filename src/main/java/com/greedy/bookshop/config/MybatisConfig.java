package com.greedy.bookshop.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.greedy.bookshop", annotationClass = Mapper.class)
public class MybatisConfig {

}

