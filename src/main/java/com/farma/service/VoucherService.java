package com.farma.service;

import java.util.Optional;

import com.farma.entities.Voucher;

public interface VoucherService extends CrudService<Voucher>{
	
	Optional<Voucher> fetchByVoucherIdWithPatientWithVoucherDetailWithMedicine(Long id) throws Exception;

}
