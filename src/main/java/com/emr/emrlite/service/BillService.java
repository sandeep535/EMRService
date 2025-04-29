package com.emr.emrlite.service;

import java.util.List;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.model.BillPayment;

public interface BillService {
	
	Long generateBill(BillGenerationDTO billGenerationDTO);

	List<BillViewDTO> getBills(Long visitId);

	BillPayment savePayment(Long billId, BillPayment payment);

}
