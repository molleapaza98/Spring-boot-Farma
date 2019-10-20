package com.farma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farma.entities.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	
	@Query("select m from Medicine m where m.name like %?1%")
	List<Medicine> fetchMedicineByName(String name);
	
	

}
