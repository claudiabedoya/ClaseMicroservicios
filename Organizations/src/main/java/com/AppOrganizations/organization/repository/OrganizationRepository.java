package com.AppOrganizations.organization.repository;

import java.util.List;

import com.AppOrganizations.organization.model.Organization;

public interface OrganizationRepository {
	
	public Organization add(Organization organization) ;
	
	public Organization findById(Long id) ;
	
	public List<Organization> findAll() ;

}
