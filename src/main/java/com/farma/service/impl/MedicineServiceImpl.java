package com.farma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farma.entities.Medicine;
import com.farma.repository.MedicineRepository;
import com.farma.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Transactional(readOnly=true)
	@Override
	public List<Medicine> findAll() throws Exception {
		return medicineRepository.findAll();
	}

	@Transactional
	@Override
	public Medicine save(Medicine t) throws Exception {
		return medicineRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Medicine> findById(Long id) throws Exception {
		return medicineRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		medicineRepository.deleteById(id);
		
	}

	@Transactional(readOnly=true)
	@Override
	public List<Medicine> fetchMedicineByName(String name) throws Exception {
		return medicineRepository.fetchMedicineByName(name);
	}

}
