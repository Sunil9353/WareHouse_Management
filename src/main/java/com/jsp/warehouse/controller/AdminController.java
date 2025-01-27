package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;



@RestController
@RequestMapping("/api/version1")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody  AdminRequest adminRequest){
		System.out.println("Controller");
		return adminService.saveAdmin(adminRequest);
	}
	
}
