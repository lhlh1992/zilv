package com.liu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liu.mvc.dao")
public class SelfDisciplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfDisciplineApplication.class, args);
	}

}
