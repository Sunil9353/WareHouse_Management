package com.jsp.warehouse.entity;




import org.springframework.beans.factory.annotation.Autowired;

import com.jsp.warehouse.enums.AdminType;
import com.jsp.warehouse.enums.Privilege;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
	@Id
	@GeneratedValue()
	private int adminId;
	private String adminName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private AdminType adminType;
	
	
	@OneToOne
	private Warehouse warehouse;
	
}