package com.amdocs.CargoManagementSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.entity.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>{

	
    
}
