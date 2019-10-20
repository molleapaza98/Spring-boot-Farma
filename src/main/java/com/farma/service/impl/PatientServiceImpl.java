package com.farma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farma.entities.Patient;
import com.farma.repository.PatientRepository;
import com.farma.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Patient> findAll() throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Transactional
	@Override
	public Patient save(Patient t) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Patient> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Patient> findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findByDni(dni);
	}


	@Transactional(readOnly=true)
	@Override
	public Optional<Patient> fetchByPatientWithVochers(Long id) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.fetchByPatientWithVochers(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Patient> fetchByPatientWithSigns(Long id) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.fetchByPatientWithSigns(id);
	}

	


	
	
}
