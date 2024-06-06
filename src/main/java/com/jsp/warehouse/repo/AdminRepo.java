package com.jsp.warehouse.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.enums.AdminType;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

    public 	boolean existsByAdminType(AdminType superAdmin);

	public Optional<Admin> finByEmail(String username);

//	Optional<Admin> findAdminFromAdmin(AdminType superAdmin);

}
