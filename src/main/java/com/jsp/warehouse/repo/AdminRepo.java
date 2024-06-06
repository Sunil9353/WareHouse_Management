package com.jsp.warehouse.repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.enums.AdminType;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

    public 	boolean existsByAdminType(AdminType superAdmin);
    
    @Query(nativeQuery = true,value = "SELECT * FROM warehouse_db.admin where email= :username")
	public Optional<Admin> finByEmail(@Param("username") String username);

//	Optional<Admin> findAdminFromAdmin(AdminType superAdmin);

}
