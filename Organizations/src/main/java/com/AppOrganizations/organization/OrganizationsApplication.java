package com.AppOrganizations.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.AppOrganizations.organization.model.Organization;
import com.AppOrganizations.organization.repository.OrganizationRepository;
import com.AppOrganizations.organization.repository.OrganizationRepositoryImpl;

@SpringBootApplication
public class OrganizationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationsApplication.class, args);
	}

	@Bean
	OrganizationRepository repository() {
		OrganizationRepository repository = new OrganizationRepositoryImpl();
		repository.add(new Organization("Microsoft", "Redmond, Washington, USA"));
		repository.add(new Organization("Oracle", "Redwood City, California, USA"));
		repository.add(new Organization("EPM", "Medellín, Colombia"));
		return repository;
	}
}
