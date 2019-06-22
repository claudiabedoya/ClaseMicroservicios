package com.AppDepartments.department.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.AppDepartments.department.model.Department;
import com.AppDepartments.department.model.Employee;

public interface EmployeeClient {
	
	//defino los métodos
	
	List<Employee> retrieveEmployeeList (final Long employee);

    List<Employee> findByDepartment(final Long id);
    
    List<Department> findByOrganizationWithEmployees(final Long organizationId);
	
}

