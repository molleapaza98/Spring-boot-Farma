package com.farma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.farma.entities.Patient;
import com.farma.service.PatientService;

@Controller
@SessionAttributes("patient")
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model model) {
		try {
			model.addAttribute("patients", patientService.findAll());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/patient/list";
	}
	
	@GetMapping("/search")
	public String searchPatient(@RequestParam("dni") String dni, Model model) {
		try {
			if(!dni.isEmpty()) {
				List<Patient> patients=patientService.findByDni(dni);
				if(!patients.isEmpty()) {
					model.addAttribute("patients",patients);
				}else {
					model.addAttribute("info", "No existe paciente");
					model.addAttribute("patients", patientService.findAll());
				}
			} else {
				model.addAttribute("info", "Debe ingresar un dni");
				model.addAttribute("patients", patientService.findAll());
			}
			
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/patient/list";
	}
	@GetMapping("/detail/{id}")
	public String detailsPatient(@PathVariable(value="id") Long id, Model model) {
		try {
			Optional<Patient> patient=patientService.findById(id);
			
			if(!patient.isPresent()) {
				model.addAttribute("info", "El paciente no existe");
				return "redirect:/patients/list";
				
			}else {
				model.addAttribute("patient",patient.get());
			}
				
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/patient/detail";
	 }
	}
	
	
	
	
	
	
	
	
	
	
	
