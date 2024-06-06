package com.jsp.warehouse.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warehouse {
	@Id
	private int wareHouseId;
	private String wareHouseName;

	@OneToOne(mappedBy = "warehouse")
	private Admin admin;




}
