package com.amdocs.CargoManagementSystem.service;

import java.util.List;

import com.amdocs.CargoManagementSystem.entity.Cargo;

public interface CargoService {

public boolean saveCargo(Cargo carg);
	
	public List<Cargo> getAllCargos();
	
	public Cargo getCargoId(int id);

	public boolean updateBook(Cargo st);

	public boolean deleteCargo(int id);
}
