package com.AppDepartments.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppDepartments.department.client.EmployeeClient;
import com.AppDepartments.department.model.Department;
import com.AppDepartments.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

//import com.AppEmployees.employee.model.Employee;

@Slf4j
@RestController
@RequestMapping("/departments")

public class DepartmentController {
	
	@Autowired
	DepartmentRepository repository;
	
	@Autowired
	EmployeeClient employeeClient;
	
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		log.info("Department add: {}", department);
		return repository.add(department);
	}
	@GetMapping("/") 
	List<Department> findAll() {
			log.info("Department  find");
			return repository.findAll();
		}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable("id_Department") Long id) {
		log.info("Department find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		log.info("Department find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}

	@GetMapping("/organization/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		log.info("DEP Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganization(organizationId);
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;
	}
}
