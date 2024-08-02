package com.emr.emrlite.repository;


import com.emr.emrlite.dto.LabMasterPaginationDTO;
import com.emr.emrlite.model.LabMasterModel;

public interface LabMasterRepository {
	public LabMasterModel saveDiagnosisMaster(LabMasterModel labMasterModel);
	public LabMasterPaginationDTO getLabMatser(LabMasterPaginationDTO labMasterPaginationDTO);
}
