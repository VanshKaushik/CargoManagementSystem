package com.amdocs.CargoManagementSystem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.entity.Truck;

import com.amdocs.CargoManagementSystem.repo.CargoRepository;
import com.amdocs.CargoManagementSystem.repo.TruckRepository;
import com.amdocs.CargoManagementSystem.service.TruckService;

@Service
public class TruckServiceImpl implements TruckService {

	
	private TruckRepository truckRepo;
	private CargoRepository cargoRepo;
	
	@Autowired
	public TruckServiceImpl(TruckRepository truckRepo, CargoRepository cargoRepo) {
		super();
		this.truckRepo = truckRepo;
		this.cargoRepo = cargoRepo;
	}

	@Override
	public Truck saveTruck(Truck tru ,int cargoId)  {
		// TODO Auto-generated method stub
		
		Cargo cargo = cargoRepo.findById(cargoId).orElse(null);
		
		if(cargo!=null) 
		{tru.setCargo(cargo);
		}
		else {throw new NoSuchElementException("Not valid");}
		return truckRepo.save(tru);
		
		
	}

	@Override
	public List<Truck> getAlltrucks() {
		// TODO Auto-generated method stub
		List<Truck> truRecords = truckRepo.findAll();
		return truRecords;
	}

	@Override
	public Truck getTruckId(long id) {
		// TODO Auto-generated method stub
		if(truckRepo.findById(id)!=null)
		{
			return truckRepo.findById(id).orElse(null);
		}
		else {
			throw new NoSuchElementException("Not valid");
		}
		
	}

	@Override
	public Truck updateBook(int cno, long tnno, Truck st) {
		// TODO Auto-generated method stub
		
		Cargo cargo = cargoRepo.findById(cno).orElse(null);
		if(cargo!=null)
		{
		Truck existingtruck = truckRepo.findById(tnno).orElse(null);
		
		if(existingtruck!=null)
		{
			existingtruck.setVehicle_number(st.getVehicle_number());
			existingtruck.setTruck_name(st.getTruck_name());
			existingtruck.setManufactureDate(st.getManufactureDate());
			existingtruck.setWeight(st.getWeight());
			return truckRepo.save(existingtruck);
			
		}
		else {
			throw new NoSuchElementException("Not valid");
		}
		}
		else {
			throw new NoSuchElementException("Not valid");
		}
		
		
	}

	@Override
	public void deleteTruck(long id) {
		// TODO Auto-generated method stub
		if(truckRepo.findById(id)!=null)
		{
			truckRepo.deleteById(id);
		}
		else {
			throw new NoSuchElementException("Not valid");
		}
	}
	


}
