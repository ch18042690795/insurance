package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(value={"com.middle.service.InsertDataService"})

public class InsuranceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InsuranceApplication.class, args);

	}

}
