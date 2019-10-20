package com.farma.service;

import java.util.List;

import com.farma.entities.Medicine;

public interface MedicineService extends CrudService<Medicine> {
	
	List<Medicine> fetchMedicineByName(String name) throws Exception;
	
	

}
