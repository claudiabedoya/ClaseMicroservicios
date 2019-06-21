package com.AppDepartments.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.AppDepartments.department.model.Department;
import com.AppDepartments.department.repository.DepartmentRepository;
import com.AppDepartments.department.repository.DepartmentRepositoryImpl;

@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	
	@Bean
	DepartmentRepository repository() {
		DepartmentRepository repository = new DepartmentRepositoryImpl();
		repository.add(new Department(1L, "Development"));
		repository.add(new Department(1L, "Operations"));
		repository.add(new Department(2L, "Development"));
		repository.add(new Department(2L, "Operations"));
		repository.add(new Department(2L, "Call Center"));
		return repository;
	}

}
