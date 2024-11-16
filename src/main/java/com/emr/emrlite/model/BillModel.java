package com.emr.emrlite.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "VISIT_BILL")
public class BillModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long billId;

	private String billNumber;

	private Date billDate;

	private Double billAmount;

	private Long visitid;

	private Long clientid;

	private Double visitTotalAmount;

	private Double visitDiscountPercentage;

	private Double visitDiscount;

}
