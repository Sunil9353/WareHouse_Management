package com.jsp.warehouse.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Admin;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
@Component
public class AdminMapper {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	

	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
	
	
	if(admin==null) {
		Admin admin2 = new Admin();
	}
	else {
		admin.setEmail(adminRequest.getEmail());
		
		admin.setAdminName(adminRequest.getAdminName());
//		admin.setPassword(adminRequest.getPassword());
		admin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
	}
	
	return admin;
		
		
		
	}
	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				.adminId(admin.getAdminId())
				.adminName(admin.getAdminName())
				
				.email(admin.getEmail())
				.adminType(admin.getAdminType())
				
				.build();
	}
}