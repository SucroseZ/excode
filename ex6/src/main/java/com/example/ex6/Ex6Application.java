package com.example.ex6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.example.ex6.mapper"})
public class Ex6Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex6Application.class, args);
	}

}
