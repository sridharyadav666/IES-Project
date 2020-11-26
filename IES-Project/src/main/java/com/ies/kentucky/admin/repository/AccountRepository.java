package com.ies.kentucky.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.kentucky.admin.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Serializable> {

	
	

	public AccountEntity findByEmail(String email);
	
	public List<AccountEntity> findByRole(String role);
	
	 @Query("select e.role from AccountEntity e")
	 public List<String> getRoles();
	
	
	
	
}
