package com.farma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="vouchers")
public class Voucher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patient_id", nullable=false)
	private Patient patientId;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="voucher_id")
	private List<VoucherDetail> voucherDetail;
	

	public Voucher(){
		voucherDetail = new ArrayList<>();
	}
	
	@PrePersist
	public void prePersist() {
		createAt= new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public List<VoucherDetail> getVoucherDetail() {
		return voucherDetail;
	}

	public void setVoucherDetail(List<VoucherDetail> voucherDetail) {
		this.voucherDetail = voucherDetail;
	}
	
	public void addVoucherDetail(VoucherDetail item) {
		this.voucherDetail.add(item);
		
	}
	
	public Double getTotal() {
		
		return voucherDetail.stream().collect(Collectors.summingDouble(VoucherDetail::calculateAmount));
		
	}
	
}
