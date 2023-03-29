package com.greedy.bookshop.common.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.greedy.bookshop.main.member.dao", annotationClass = Mapper.class)
public class MybatisConfig {

}

