package com.school.MySchool;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySchoolApplication.class, args);
	}


	@Bean
	ModelMapper modelmapper() {
		return new ModelMapper();

	}
}
