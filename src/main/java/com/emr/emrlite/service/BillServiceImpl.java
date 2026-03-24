package com.emr.emrlite.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.dto.BillPaymentDTO;
import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.dto.VisitDetailsDTO;
import com.emr.emrlite.model.BillModel;
import com.emr.emrlite.model.BillPayment;
import com.emr.emrlite.model.BillSequenceGenerator;
import com.emr.emrlite.model.VisitDetailsModel;
import com.emr.emrlite.model.MasterDataModel;
import com.emr.emrlite.repository.MasterDataRepository;
import com.emr.emrlite.repository.BillPaymentRepository;
import com.emr.emrlite.repository.BillRepository;
import com.emr.emrlite.repository.BillSequenceGeneratorRepository;
import com.emr.emrlite.repository.VisitDetailsRepository;
import com.emr.emrlite.repository.VisitServicesRepository;

import jakarta.transaction.Transactional;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private VisitDetailsRepository visitDetailsRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private BillPaymentRepository billPaymentRepository;

	@Autowired
	private MasterDataRepository masterDataRepository;

	@Autowired
	private VisitServicesRepository visitServicesRepository;

	@Autowired
	private BillSequenceGeneratorRepository billSequenceGeneratorRepository;

	@Override
	@Transactional
	public Long generateBill(BillGenerationDTO billGenerationDTO) {

		VisitDetailsModel visitDetailsModel = visitDetailsRepository.getVisitDeatils(billGenerationDTO.getVisitid());

		BillModel bill = BillModel.builder().billAmount(visitDetailsModel.getVisittotalamount().doubleValue())
				.billDate(new Date()).billNumber(generateBillNumber()).clientid(billGenerationDTO.getClientId())
				.visitDiscountPercentage(visitDetailsModel.getVisitpercentage().doubleValue())
				.visitDiscount(visitDetailsModel.getVisitdiscount().doubleValue())
				.visitid(billGenerationDTO.getVisitid()).build();

		Long billId = billRepository.saveBill(bill);

		visitDetailsRepository.updateVisitAmount(0, 0, 0, billGenerationDTO.getVisitid());

		visitServicesRepository.updateVisitStatus(billId, billGenerationDTO.getVisitid());

		return billId;

	}

	private String generateBillNumber() {

		Optional<BillSequenceGenerator> billSequenceGenerator = billSequenceGeneratorRepository.findById(1l);

		Long SequenceNum = billSequenceGenerator.get().getSequenceNumber();

		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		int day = LocalDate.now().getDayOfMonth();

		String invNumber = "INV_" + day + "" + month + "" + year + "_" + SequenceNum + 1;

		billSequenceGenerator.get().setSequenceNumber(SequenceNum + 1);
		billSequenceGeneratorRepository.save(billSequenceGenerator.get());

		return invNumber;
	}

	@Override
	public List<BillViewDTO> getBills(Long visitId) {
		List<BillViewDTO> bills = billRepository.getBillsByVisitId(visitId);
		return bills;
	}

	@Override
	public BillPayment savePayment(Long billId, BillPaymentDTO dto) {
		BillModel bill = billRepository.findByBillId(billId);
		if (bill == null) throw new RuntimeException("Bill not found with id: " + billId);
		MasterDataModel paymentMode = masterDataRepository.findById(dto.getPaymentMode())
				.orElseThrow(() -> new RuntimeException("Payment mode not found"));
		BillPayment payment = new BillPayment();
		payment.setBill(bill);
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setPaymentAmount(dto.getPaymentAmount());
		payment.setPaymentMode(paymentMode);
		payment.setRemarks(dto.getRemarks());
		return billPaymentRepository.save(payment);
	}

	@Override
	public List<BillPayment> getPaymentsByBillId(Long billId) {

		return billPaymentRepository.findByBill_BillId(billId);
	}

	@Override
	public List<VisitDetailsModel> getPendingBillsByClientId(Long clientId, String status) {
		return billPaymentRepository.findPendingBillsByClientId(clientId, status);
	}

	@Override
	public List<BillViewDTO> getBillsWithPayments(String billNumber, Long visitId, Long clientId) {
		return billRepository.getBillsWithPayments(billNumber, visitId, clientId);
	}
	


}
