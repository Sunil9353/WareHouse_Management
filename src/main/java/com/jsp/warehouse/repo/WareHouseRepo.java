package com.jsp.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.warehouse.entity.Warehouse;

@Repository
public interface WareHouseRepo extends JpaRepository<Warehouse, Integer> {
	

}
