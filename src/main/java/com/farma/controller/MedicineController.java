package com.farma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.farma.entities.Medicine;
import com.farma.service.MedicineService;

@Controller
@RequestMapping("/medicines")
@SessionAttributes("medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping(value="/list/{name}", produces= {"application/json"})
	public @ResponseBody List<Medicine> fetchMedicines(@PathVariable String name , Model model){
		List<Medicine> medicines = null;
		try {
			medicines = medicineService.fetchMedicineByName(name);
			
		}catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return medicines;
	}

}
