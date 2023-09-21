package com.amdocs.CargoManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.CargoManagementSystem.entity.Cargo;
import com.amdocs.CargoManagementSystem.service.impl.CargoServiceImpl;


@Controller
public class CargoController {

	@Autowired
	private CargoServiceImpl cargService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		Cargo carg =new Cargo();
		model.addAttribute("carg", carg);
		
		return "cargo";
	}
	
	@RequestMapping("/insert")
	public String handleCargForm(@ModelAttribute("carg")Cargo carg,Model model)
	{
		
		//interact to service layer
		boolean saveCargo = cargService.saveCargo(carg);
		
		System.out.println(saveCargo);
		
		String msg="";
		
		if(saveCargo)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "cargo";
	}
	
	@RequestMapping("/viewAll")
	public String viewAllCargos(Model model)
	{
		//fetch the data from the databse ,can interact service layer
		List<Cargo> allCargos = cargService.getAllCargos();
		
		model.addAttribute("cargos", allCargos);
		return "view";
	}
	
	@RequestMapping("/deleteCarg")
	public String deleteCargo(@RequestParam("cid")     int id)
	{
		boolean flag = cargService.deleteCargo(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	@RequestMapping("/editCarg")
	public String editCargo(@RequestParam("cid")   int id,Model model)
	{
		Cargo carg = cargService.getCargoId(id);
		
		model.addAttribute("carg", carg);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateCargo(Cargo carg)
	{
		boolean updateBook = cargService.updateBook(carg);
		
		return "redirect:/viewAll";

	}
	
}
