package com.AppEmployees.employee.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.AppEmployees.employee.model.Employee;


public class EmployeeRepositoryImpl implements EmployeeRepository {
	

	private List<Employee> employees = new ArrayList<>();

	@Override
	public Employee add(Employee employee) {
		employee.setId((long) (employees.size()+1));
		employees.add(employee);
		return employee;
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}

	@Override
	public List<Employee> findAll() {
		return employees;
	}

	@Override
	public List<Employee> findByDepartment(Long departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
	}

	@Override
	public List<Employee> findByOrganization(Long organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
	}


}
