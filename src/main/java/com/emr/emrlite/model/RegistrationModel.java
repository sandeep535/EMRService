package com.emr.emrlite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EMR_Registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seqid;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "title" ,referencedColumnName = "lookupid")
    private LookUpModel title;

    private String firstname;
    private String lastname;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "gender" ,referencedColumnName = "lookupid")
    private LookUpModel gender;

    private String contact;
    private String email;
    private String dob;
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address" ,referencedColumnName = "addressid")
    private AddressModel address;

	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public LookUpModel getTitle() {
		return title;
	}

	public void setTitle(LookUpModel title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LookUpModel getGender() {
		return gender;
	}

	public void setGender(LookUpModel gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}


}
