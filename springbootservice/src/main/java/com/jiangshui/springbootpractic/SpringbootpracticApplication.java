package com.jiangshui.springbootpractic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jiangshui.springbootpractic.mapper.*")
public class SpringbootpracticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpracticApplication.class, args);
	}
}
