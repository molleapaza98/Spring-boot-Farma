package com.farma.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farma.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	List<Patient> findByDni(String dni);
	
	@Query("select p from Patient p left join fetch p.vouchers v where p.id=?1")
	Optional<Patient>  fetchByPatientWithVochers(Long id);
	
	@Query("select p from Patient p left join fetch p.signs s where p.id=?1")
	Optional<Patient>  fetchByPatientWithSigns(Long id);

}
