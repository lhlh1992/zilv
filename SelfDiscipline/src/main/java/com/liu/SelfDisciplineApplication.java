package com.liu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.liu.mvc.dao")
@EnableTransactionManagement
public class SelfDisciplineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfDisciplineApplication.class, args);
	}
	
	

}
