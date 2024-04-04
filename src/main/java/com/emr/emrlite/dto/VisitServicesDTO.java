package com.emr.emrlite.dto;

import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.LookUpModel;
import com.emr.emrlite.model.SpecilaityMasterModel;
import com.emr.emrlite.model.VisitServicesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitServicesDTO {

    private Long id;
    private Long visitid;
    private Long serviceid;
    private Float serviceprice;
    private Float servicediscount;
    private Float quantity;
    private Float servicetotalamount;
    private Float servicediscountinpercentage;
    private Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Long getServiceid() {
		return serviceid;
	}
	public void setServiceid(Long serviceid) {
		this.serviceid = serviceid;
	}
	public Float getServiceprice() {
		return serviceprice;
	}
	public void setServiceprice(Float serviceprice) {
		this.serviceprice = serviceprice;
	}
	public Float getServicediscount() {
		return servicediscount;
	}
	public void setServicediscount(Float servicediscount) {
		this.servicediscount = servicediscount;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getServicetotalamount() {
		return servicetotalamount;
	}
	public void setServicetotalamount(Float servicetotalamount) {
		this.servicetotalamount = servicetotalamount;
	}
	public Float getServicediscountinpercentage() {
		return servicediscountinpercentage;
	}
	public void setServicediscountinpercentage(Float servicediscountinpercentage) {
		this.servicediscountinpercentage = servicediscountinpercentage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
