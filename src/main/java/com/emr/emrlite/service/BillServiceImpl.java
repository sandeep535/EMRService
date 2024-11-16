package com.emr.emrlite.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.emrlite.dto.BillGenerationDTO;
import com.emr.emrlite.model.BillModel;
import com.emr.emrlite.model.BillSequenceGenerator;
import com.emr.emrlite.model.VisitDetailsModel;
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
	private VisitServicesRepository visitServicesRepository;

	@Autowired
	private BillSequenceGeneratorRepository billSequenceGeneratorRepository;

	@Override
	@Transactional
	public void generateBill(BillGenerationDTO billGenerationDTO) {

		VisitDetailsModel visitDetailsModel = visitDetailsRepository.getVisitDeatils(billGenerationDTO.getVisitid());

		BillModel bill = BillModel.builder().billAmount(visitDetailsModel.getVisittotalamount().doubleValue())
				.billDate(new Date()).billNumber(generateBillNumber()).clientid(billGenerationDTO.getClientId())
				.visitDiscountPercentage(visitDetailsModel.getVisitpercentage().doubleValue())
				.visitDiscount(visitDetailsModel.getVisitdiscount().doubleValue())
				.visitid(billGenerationDTO.getVisitid()).build();

		Long billId = billRepository.saveBill(bill);

		visitDetailsRepository.updateVisitAmount(0, 0, 0, billGenerationDTO.getVisitid());

		visitServicesRepository.updateVisitStatus(billId, billGenerationDTO.getVisitid());

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
	public List<BillModel> getBills(Long visitId) {
		List<BillModel> bills = billRepository.getBillsByVisitId(visitId);
		return bills;
	}

}
