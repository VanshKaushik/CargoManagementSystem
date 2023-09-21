package com.amdocs.CargoManagementSystem.service;

import java.util.List;
import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.entity.Truck;
public interface TruckService {

	public Truck saveTruck(Truck tru, int cargoId);
	public List<Truck> getAlltrucks();
	public Truck getTruckId(long id);
	public Truck updateBook(int cno, long tnno, Truck st);
	public void deleteTruck(long id);
	 
}
