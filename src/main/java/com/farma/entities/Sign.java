package com.farma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="signs")
public class Sign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@DecimalMin("1.00")
	@Column(name="temperature", columnDefinition= "Decimal(8,2)", nullable= false)
	private Double temperature;
	
	@DecimalMin("1.00")
	@Column(name="pulse", columnDefinition= "Decimal(8,2)", nullable= false)
	private Double pulse;
	
	@DecimalMin("1.00")
	@Column(name="respiratory_rhythm", columnDefinition= "Decimal(8,2)", nullable= false)
	private Double respiratoryRhythm;

	@NotNull(message="Debe seleccionar un paciente")
	@ManyToOne
	@JoinColumn(name="patient_id", nullable = false)
	private Patient patientId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getPulse() {
		return pulse;
	}

	public void setPulse(Double pulse) {
		this.pulse = pulse;
	}

	public Double getRespiratoryRhythm() {
		return respiratoryRhythm;
	}

	public void setRespiratoryRhythm(Double respiratoryRhythm) {
		this.respiratoryRhythm = respiratoryRhythm;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}	
	
	
	

}
