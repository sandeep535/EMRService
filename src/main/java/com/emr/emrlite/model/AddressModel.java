package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emr_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressid;
    private String address1;
    private String address2;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "country" ,referencedColumnName = "countryid")
    private CountriesModel country;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "state" ,referencedColumnName = "stateid")
    private StateModel state;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "city" ,referencedColumnName = "cityid")
    private CityModel city;

    private Integer pincode;

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public CountriesModel getCountry() {
		return country;
	}

	public void setCountry(CountriesModel country) {
		this.country = country;
	}

	public StateModel getState() {
		return state;
	}

	public void setState(StateModel state) {
		this.state = state;
	}

	public CityModel getCity() {
		return city;
	}

	public void setCity(CityModel city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
    
    
}
