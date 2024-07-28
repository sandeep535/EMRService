package com.emr.emrlite.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.emr.emrlite.dto.AllergiesRequestDTO;
import com.emr.emrlite.dto.DiagnosisMasterDTO;
import com.emr.emrlite.dto.DiagnosisMasterPaginationDTO;
import com.emr.emrlite.model.AllergiesModel;
import com.emr.emrlite.model.DiagnosisMasterModel;
import com.emr.emrlite.repository.DiagnosisMasterRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class DiagnosisMasterRepositoryImpl implements DiagnosisMasterRepository{
	@Autowired
    EntityManager entityManager;

	@Override
	public DiagnosisMasterModel saveDiagnosisMaster(DiagnosisMasterModel diagnosisMasterDTO) {
		
		 entityManager.merge(diagnosisMasterDTO);
		 DiagnosisMasterModel diagnosisMasterModel1 = new DiagnosisMasterModel();
	        diagnosisMasterModel1.setDignosisid(diagnosisMasterDTO.getDignosisid());
	        return diagnosisMasterModel1;
		
	}

	@Override
	public DiagnosisMasterPaginationDTO getDiagnosisMatser(DiagnosisMasterPaginationDTO diagnosisMasterPaginationDTO) {
		
		  Pageable paging = PageRequest.of(diagnosisMasterPaginationDTO.getPagenumber(), diagnosisMasterPaginationDTO.getPagesize());
		  CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		  CriteriaQuery<DiagnosisMasterModel> cq = cb.createQuery(DiagnosisMasterModel.class);
		  List<Predicate> predicates = new ArrayList<>();
		  Root<DiagnosisMasterModel> diagnosisMasterModelRoot = cq.from(DiagnosisMasterModel.class);
		  DiagnosisMasterModel request = diagnosisMasterPaginationDTO.getDiagnosisMasterModel().get(0);
		  predicates.add(cb.like(diagnosisMasterModelRoot.get("dignosisname"), "%" + request.getDignosisname() + "%"));
		  if(request.getStatus() != -999) {
			  predicates.add(cb.and(cb.equal(diagnosisMasterModelRoot.get("status"), request.getStatus())));
		  }
		  if(request.getDignosiscode() != null) {
			  predicates.add(cb.and(cb.equal(diagnosisMasterModelRoot.get("dignosiscode"), request.getDignosiscode())));
		  }
		  if(request.getDignosiscodeset() != null) {
			  predicates.add(cb.and(cb.equal(diagnosisMasterModelRoot.get("dignosiscodeset"), request.getDignosiscodeset())));
		  }
		  
		  cq.select(diagnosisMasterModelRoot).where(predicates.toArray(new Predicate[] {}));
		  List<DiagnosisMasterModel> result;
		  result = entityManager.createQuery(cq).setFirstResult((int) paging.getOffset()).setMaxResults(paging.getPageSize()).getResultList();
		  diagnosisMasterPaginationDTO.setDiagnosisMasterModel(result);
		  return diagnosisMasterPaginationDTO;
	}

	
	
    
}
