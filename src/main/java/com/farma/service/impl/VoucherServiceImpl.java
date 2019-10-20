package com.farma.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farma.entities.Voucher;
import com.farma.repository.VoucherRepository;
import com.farma.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService{

	@Autowired
	private VoucherRepository voucherRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Voucher> findAll() throws Exception {
		// TODO Auto-generated method stub
		return voucherRepository.findAll();
	}

	@Transactional
	@Override
	public Voucher save(Voucher t) throws Exception {
		// TODO Auto-generated method stub
		return voucherRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Voucher> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return voucherRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		voucherRepository.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Voucher> fetchByVoucherIdWithPatientWithVoucherDetailWithMedicine(Long id) throws Exception {
		// TODO Auto-generated method stub
		return voucherRepository.fetchByVoucherIdWithPatientWithVoucherDetailWithMedicine(id);
	}

}
