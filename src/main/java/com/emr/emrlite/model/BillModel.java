package com.emr.emrlite.model;

import java.util.Date;

import jakarta.persistence.Column;
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
	@Column(name="BILL_ID")
	private Long billId;

	@Column(name="BILL_NUM")
	private String billNumber;

	@Column(name="BILL_DATE")
	private Date billDate;

	@Column(name="BILL_AMOUNT")
	private Double billAmount;

	@Column(name="VISIT_ID")
	private Long visitid;

	@Column(name="CLIENT_ID")
	private Long clientid;

	@Column(name="VISIT_TOTAL_AMOUNT")
	private Double visitTotalAmount;

	@Column(name="VISIT_DISCOUNT_PERCENTAGE")
	private Double visitDiscountPercentage;

	@Column(name="VISIT_DISCOUNT")
	private Double visitDiscount;

}
