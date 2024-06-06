package com.jsp.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.warehouse.entity.Warehouse;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.utility.ResponseStructure;

@RestController
@RequestMapping("/api/version1")
public class WareHouseController {
//	@Autowired
//	private WareHouseService wareHouseService;
	
	
	
	@GetMapping("/warehouses")
	public String createWareHouse() {
	
		return "wareHouse found";
	}

}
