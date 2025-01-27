package com.jsp.warehouse.mapper;

import org.springframework.stereotype.Component;

import com.jsp.warehouse.entity.Admin;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
@Component
public class AdminMapper {

	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
	
	
	if(admin==null) {
		Admin admin2 = new Admin();
	}
	else {
		admin.setAdminEmail(adminRequest.getAdminEmail());
		admin.setAdminName(adminRequest.getAdminName());
		admin.setPassword(adminRequest.getPassword());
	}
	
	return admin;
		
		
		
	}
	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				.adminId(admin.getAdminId())
				.adminName(admin.getAdminName())
				.adminEmail(admin.getAdminEmail())
				.adminType(admin.getAdminType())
				
				.build();
	}
}