package com.farma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farma.entities.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long>{
	
	@Query("select v from Voucher v join fetch v.patientId p join fetch v.voucherDetail vd join fetch vd.medicineId where v.id=?1")
	Optional<Voucher> fetchByVoucherIdWithPatientWithVoucherDetailWithMedicine(Long id);

}
