package com.emr.emrlite.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.emr.emrlite.dto.BillViewDTO;
import com.emr.emrlite.model.BillModel;
import com.emr.emrlite.model.BillPayment;
import com.emr.emrlite.model.VisitServicesModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BillRepositoryImpl implements BillRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Long saveBill(BillModel bill) {
		entityManager.persist(bill);
		return bill.getBillId();

	}

	@Override
	public List<BillViewDTO> getBillsByVisitId(Long visitId) {

		List<BillViewDTO> bills = new ArrayList<>();
		Query query = entityManager.createQuery("select bill from BillModel bill where bill.visitid=:visitid",
				BillModel.class);
		query.setParameter("visitid", visitId);
		List<BillModel> results = query.getResultList();

		for (BillModel b : results) {
			BillViewDTO bill = new BillViewDTO();
			bill.setBillId(b.getBillId());
			bill.setBillNumber(b.getBillNumber());
			bill.setBillAmount(b.getBillAmount());
			bill.setBillDate(b.getBillDate());
			bill.setVisitid(b.getVisitid());
			bill.setVisitDiscount(b.getVisitDiscount());
			bill.setVisitDiscountPercentage(b.getVisitDiscountPercentage());
			bill.setBillAmountBeforeDiscount(b.getBillAmount() + b.getVisitDiscount());
			double payAmount = 0;
			if(!CollectionUtils.isEmpty(b.getPayments())) {
				payAmount = b.getPayments().stream().mapToDouble((BillPayment t) -> t.getPaymentAmount()).sum();
			}
			bill.setPaymentAmount(payAmount);
			
			Query query1 = entityManager.createQuery("select vs from VisitServicesModel vs where vs.billId=:billId",
					VisitServicesModel.class);
			query1.setParameter("billId", b.getBillId());

			List<VisitServicesModel> services = query1.getResultList();
			bill.setServices(services);

			bills.add(bill);

		}

		return bills;
	}

	@Override
	public BillModel findByBillId(Long billId) {
		return entityManager.find(BillModel.class, billId);
	}

	@Override
	public List<BillViewDTO> getBillsWithPayments(String billNumber, Long visitId, Long clientId) {
		StringBuilder jpql = new StringBuilder("select b from BillModel b where 1=1");
		if (billNumber != null) jpql.append(" and b.billNumber = :billNumber");
		if (visitId != null)    jpql.append(" and b.visitid = :visitId");
		if (clientId != null)   jpql.append(" and b.clientid = :clientId");

		Query query = entityManager.createQuery(jpql.toString(), BillModel.class);
		if (billNumber != null) query.setParameter("billNumber", billNumber);
		if (visitId != null)    query.setParameter("visitId", visitId);
		if (clientId != null)   query.setParameter("clientId", clientId);

		List<BillModel> results = query.getResultList();
		List<BillViewDTO> bills = new ArrayList<>();

		for (BillModel b : results) {
			BillViewDTO dto = new BillViewDTO();
			dto.setBillId(b.getBillId());
			dto.setBillNumber(b.getBillNumber());
			dto.setBillAmount(b.getBillAmount());
			dto.setBillDate(b.getBillDate());
			dto.setVisitid(b.getVisitid());
			dto.setClientid(b.getClientid());
			dto.setVisitDiscount(b.getVisitDiscount());
			dto.setVisitDiscountPercentage(b.getVisitDiscountPercentage());
			dto.setBillAmountBeforeDiscount(b.getBillAmount() + b.getVisitDiscount());
			double payAmount = 0;
			if (!CollectionUtils.isEmpty(b.getPayments())) {
				payAmount = b.getPayments().stream().mapToDouble(BillPayment::getPaymentAmount).sum();
			}
			dto.setPaymentAmount(payAmount);
			dto.setPayments(b.getPayments());

			Query svcQuery = entityManager.createQuery("select vs from VisitServicesModel vs where vs.billId = :billId", VisitServicesModel.class);
			svcQuery.setParameter("billId", b.getBillId());
			dto.setServices(svcQuery.getResultList());

			bills.add(dto);
		}
		return bills;
	}

}
