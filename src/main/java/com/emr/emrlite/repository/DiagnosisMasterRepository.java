package com.emr.emrlite.repository;



import com.emr.emrlite.dto.DiagnosisMasterPaginationDTO;
import com.emr.emrlite.model.DiagnosisMasterModel;

public interface DiagnosisMasterRepository{
	public DiagnosisMasterModel saveDiagnosisMaster(DiagnosisMasterModel diagnosisMasterDTO);
	public DiagnosisMasterPaginationDTO getDiagnosisMatser(DiagnosisMasterPaginationDTO diagnosisMasterDTO);
}
