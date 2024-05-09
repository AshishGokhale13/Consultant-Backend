package com.mbpatil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mbpatil.models.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	@Query("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password")
	Admin findAdmin(String username, String password);

}
