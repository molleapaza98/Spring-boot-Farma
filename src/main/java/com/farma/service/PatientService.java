package com.farma.service;

import java.util.List;
import java.util.Optional;

import com.farma.entities.Patient;

public interface PatientService extends CrudService<Patient>{
	
	List<Patient> findByDni(String dni) throws Exception;
	
	Optional<Patient>  fetchByPatientWithVochers(Long id)  throws Exception;
	
	Optional<Patient>  fetchByPatientWithSigns(Long id) throws Exception;

}
