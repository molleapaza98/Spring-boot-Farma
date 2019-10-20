package com.farma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="voucher_details")
public class VoucherDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="medicine_id")
	private Medicine medicineId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Medicine getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Medicine medicineId) {
		this.medicineId = medicineId;
	}
	
	public Double calculateAmount() {
		return quantity*medicineId.getPrice();
	}

}
