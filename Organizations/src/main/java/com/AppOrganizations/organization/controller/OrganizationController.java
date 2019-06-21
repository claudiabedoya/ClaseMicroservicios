package com.AppOrganizations.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.AppOrganizations.organization.model.Organization;
import com.AppOrganizations.organization.repository.OrganizationRepository;

@Slf4j
@RestController
@RequestMapping("/organizations")


public class OrganizationController {

	@Autowired
	OrganizationRepository repository;
	//@Autowired
	//DepartmentClient departmentClient;
	//@Autowired
	//EmployeeClient employeeClient;
	
	@PostMapping
	public Organization add(@RequestBody Organization organization) {
		log.info("Organization add: {}", organization);
		return repository.add(organization);
	}
	
	@GetMapping
	public List<Organization> findAll() {
		log.info("Organization find");
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organization findById(@PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		return repository.findById(id);
	}
}
