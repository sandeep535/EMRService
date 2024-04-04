package com.emr.emrlite.dto;

import com.emr.emrlite.model.AllergiesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveVisitDataDTO {
    Long clientid;
    Long visitid;
    Long capturedby;
    List<PrescriptionsDTO> prescriptions;
    VitalsDTO vitalsDTO;
    NotesDTO notesDTO;
    DiagnosisDTO diagnosisDTO;
    List<AllergiesModel> allergies;
	public Long getClientid() {
		return clientid;
	}
	public void setClientid(Long clientid) {
		this.clientid = clientid;
	}
	public Long getVisitid() {
		return visitid;
	}
	public void setVisitid(Long visitid) {
		this.visitid = visitid;
	}
	public Long getCapturedby() {
		return capturedby;
	}
	public void setCapturedby(Long capturedby) {
		this.capturedby = capturedby;
	}
	public List<PrescriptionsDTO> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<PrescriptionsDTO> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public VitalsDTO getVitalsDTO() {
		return vitalsDTO;
	}
	public void setVitalsDTO(VitalsDTO vitalsDTO) {
		this.vitalsDTO = vitalsDTO;
	}
	public NotesDTO getNotesDTO() {
		return notesDTO;
	}
	public void setNotesDTO(NotesDTO notesDTO) {
		this.notesDTO = notesDTO;
	}
	public DiagnosisDTO getDiagnosisDTO() {
		return diagnosisDTO;
	}
	public void setDiagnosisDTO(DiagnosisDTO diagnosisDTO) {
		this.diagnosisDTO = diagnosisDTO;
	}
	public List<AllergiesModel> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<AllergiesModel> allergies) {
		this.allergies = allergies;
	}
    
    

}
