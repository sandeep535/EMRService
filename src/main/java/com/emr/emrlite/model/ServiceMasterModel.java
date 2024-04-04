package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="service_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMasterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long serviceid;
    private String servicename;
    private Float price;
    private Integer active;
	public Long getServiceid() {
		return serviceid;
	}
	public void setServiceid(Long serviceid) {
		this.serviceid = serviceid;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}

    
}
