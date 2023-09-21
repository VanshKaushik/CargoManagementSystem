package com.amdocs.CargoManagementSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.CargoManagementSystem.entity.Truck;

import com.amdocs.CargoManagementSystem.service.TruckService;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

	private TruckService truckserv;
	
	@Autowired
	public TruckController(TruckService truckserv) {
		//super();
		this.truckserv = truckserv;
	}
	
	@PostMapping("/insertTruck/cargo/{cargoId}")
	public Truck saveTruck(@RequestBody Truck truck ,@PathVariable int cargoId) 
	{
		
		return truckserv.saveTruck(truck ,cargoId);
	}
	
	@GetMapping("/alltrucks")
	public List<Truck> getAlltrucks()
	{
		return truckserv.getAlltrucks();
		
	}
	
	@GetMapping("/{tnno}")
	public Truck getBookById(@PathVariable Long tnno)
	{
		return truckserv.getTruckId(tnno);
	}
	
	@PutMapping("/updateTruck/{cno}/{tnno}") 
	public Truck updateBook(@PathVariable int cno, @PathVariable Long tnno,@RequestBody Truck truck) 
	{
		return truckserv.updateBook(cno, tnno, truck);
	}
	@DeleteMapping("/delete/{tnno}")
	public void deleteBook(@PathVariable Long tnno)
	{
		truckserv.deleteTruck(tnno);
	}
	@ExceptionHandler({NoSuchElementException.class ,ArithmeticException.class})
	public ResponseEntity<Map<String, String>> handleException(Exception e)
	{
		Map<String, String> errorResponse = new HashMap<String, String>();
		errorResponse.put("message", e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
