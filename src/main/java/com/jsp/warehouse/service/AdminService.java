package com.jsp.warehouse.service;

import org.springframework.http.ResponseEntity;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@Valid AdminRequest adminRequest);
	
}
