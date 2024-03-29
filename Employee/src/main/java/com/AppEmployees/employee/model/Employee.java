package com.AppEmployees.employee.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Employee {
	
	private Long id;
	private Long organizationId;
	private Long departmentId;
	private String nombre;
	private int age;
	private String position;

	
	public Employee(Long organizationId, Long departmentId, String name, int age, String position) {
		this.organizationId = organizationId;
		this.departmentId = departmentId;
		this.nombre = name;
		this.age = age;
		this.position = position;
	}

	
}
