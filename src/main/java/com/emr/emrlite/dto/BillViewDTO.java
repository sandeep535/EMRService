package com.emr.emrlite.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.emr.emrlite.model.VisitServicesModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillViewDTO {

	private Long billId;

	private String billNumber;

	private Date billDate;

	private Double billAmount;
	
	private Double billAmountBeforeDiscount;

	private Long visitid;

	private Long clientid;

	private Double visitTotalAmount;

	private Double visitDiscountPercentage;

	private Double visitDiscount;
	
	private List<VisitServicesModel> services;

}
