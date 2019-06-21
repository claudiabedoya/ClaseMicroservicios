package com.AppDepartments.department.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.AppDepartments.department.model.Employee;


@Component
public class EmployeeClientImpl implements EmployeeClient {


	//implementar lo que hace cada método

	private final RestTemplate restTemplate;
	private final String EmployeeHost;


	@Autowired
	public EmployeeClientImpl(final RestTemplate restTemplate, @Value("${employeeHost}") final String employeeHost) {
		this.restTemplate = restTemplate;
		this.EmployeeHost = employeeHost;
	}

	@Override
	public List<Employee> retrieveEmployeeList(Long employee) {
		ResponseEntity<List<Employee>> response = restTemplate.exchange(
				EmployeeHost + "/employees/" + employee,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Employee>>(){});
		return response.getBody();
	}
	
	//findByDepartment
	
	@GetMapping("/employees/department/{departmentId}")
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);


	/*@Override
	public List<Employee> retrieveEmployeeList(Long employee) {
		// TODO Auto-generated method stub

		ResponseEntity<List<Employee>> response = restTemplate.exchange(
		  "http://localhost:8080/employees/",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<Employee>>(){});
		List<Employee> employees = response.getBody();
		return employees;
	}*/



}
