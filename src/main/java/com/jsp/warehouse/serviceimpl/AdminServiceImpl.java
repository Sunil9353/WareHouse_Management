package com.jsp.warehouse.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.warehouse.entity.Admin;
import com.jsp.warehouse.enums.AdminType;
import com.jsp.warehouse.enums.Privilege;
import com.jsp.warehouse.exception.IllegalOperationException;
import com.jsp.warehouse.mapper.AdminMapper;
import com.jsp.warehouse.repo.AdminRepo;
import com.jsp.warehouse.requestdto.AdminRequest;
import com.jsp.warehouse.responsedto.AdminResponse;
import com.jsp.warehouse.service.AdminService;
import com.jsp.warehouse.utility.ResponseStructure;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;
@Service
public class AdminServiceImpl implements  AdminService{
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private AdminMapper adminMapper; 

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(AdminRequest adminRequest) {

		if(adminRepo.existsByAdminType(AdminType.SUPER_ADMIN)) { 

			throw new IllegalOperationException(" only admin can make this one");
		}
		
			Admin admin	=adminMapper.mapToAdmin(adminRequest, new Admin());

			admin.setAdminType(AdminType.SUPER_ADMIN);
//			admin.setPrivileges(java.util.List.of(Privilege.CREATE_ADMIN,Privilege.CREATE_WAREHOUSE));
			admin= adminRepo.save(admin);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<AdminResponse>()
						.setData(adminMapper.mapToAdminResponse(admin))
						.setMessage("Admin Saved Successfully")
						.setStatus(HttpStatus.CREATED.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@Valid AdminRequest adminRequest) {
		
		return null;
	}
}