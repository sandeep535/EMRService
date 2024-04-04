package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="vitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VitalsModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long vitalid;
    Long visitid;
    Long clientid;
    Float height;
    Float weight;
    Float bmi;
    Float systolic;
    Float diastolic;
    Float pulse;
    Float respiratoryrate;
    Float temperature;
    Long capturedby;
	public Long getVitalid() {
		return vitalid;
	}
	public void setVitalid(Long vitalid) {
		this.vitalid = vitalid;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getBmi() {
		return bmi;
	}
	public void setBmi(Float bmi) {
		this.bmi = bmi;
	}
	public Float getSystolic() {
		return systolic;
	}
	public void setSystolic(Float systolic) {
		this.systolic = systolic;
	}
	public Float getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(Float diastolic) {
		this.diastolic = diastolic;
	}
	public Float getPulse() {
		return pulse;
	}
	public void setPulse(Float pulse) {
		this.pulse = pulse;
	}
	public Float getRespiratoryrate() {
		return respiratoryrate;
	}
	public void setRespiratoryrate(Float respiratoryrate) {
		this.respiratoryrate = respiratoryrate;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Long getCapturedby() {
		return capturedby;
	}
	public void setCapturedby(Long capturedby) {
		this.capturedby = capturedby;
	}
    
    
    
}

