package com.emr.emrlite.service;

import java.util.List;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.dto.BillPaymentDTO;
import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.model.BillPayment;
import com.emr.emrlite.model.VisitDetailsModel;

public interface BillService {
	
	Long generateBill(BillGenerationDTO billGenerationDTO);

	List<BillViewDTO> getBills(Long visitId);

	BillPayment savePayment(Long billId, BillPaymentDTO payment);

	List<BillPayment> getPaymentsByBillId(Long billId);
	
	List<VisitDetailsModel> getPendingBillsByClientId(Long clientId, String status);

	List<BillViewDTO> getBillsWithPayments(String billNumber, Long visitId, Long clientId);

}
