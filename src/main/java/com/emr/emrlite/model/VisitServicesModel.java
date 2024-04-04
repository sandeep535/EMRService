package com.emr.emrlite.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="visit_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitServicesModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long visitid;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "serviceid" ,referencedColumnName = "serviceid")
    private ServiceMasterModel serviceid;

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
	public ServiceMasterModel getServiceid() {
		return serviceid;
	}
	public void setServiceid(ServiceMasterModel serviceid) {
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
