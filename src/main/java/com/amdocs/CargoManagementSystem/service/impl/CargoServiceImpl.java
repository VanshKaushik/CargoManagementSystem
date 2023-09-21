package com.amdocs.CargoManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.repo.CargoRepository;
import com.amdocs.CargoManagementSystem.service.CargoService;


@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargRepo;
	
	
	@Override
	public boolean saveCargo(Cargo carg) {
		// TODO Auto-generated method stub
		Cargo cargSave = cargRepo.save(carg);
		boolean flag = false;

		if (cargSave != null)
			flag = true;

		return flag;
	}

	@Override
	public List<Cargo> getAllCargos() {
		// TODO Auto-generated method stub
		List<Cargo> cargRecords = cargRepo.findAll();
		return cargRecords;
	}

	@Override
	public Cargo getCargoId(int id) {
		// TODO Auto-generated method stub
		Optional<Cargo> cargId = cargRepo.findById(id);
		Cargo carg = cargId.get();
		return carg;
	}

	@Override
	public boolean updateBook(Cargo st) {
		// TODO Auto-generated method stub
		return saveCargo(st);
	}

	@Override
	public boolean deleteCargo(int id) {
		// TODO Auto-generated method stub
		Cargo carg = getCargoId(id);
		boolean flag=false;
		if(carg!=null)
		{
			cargRepo.delete(carg);
		flag=true;	
		}
		return flag;
	}

}
