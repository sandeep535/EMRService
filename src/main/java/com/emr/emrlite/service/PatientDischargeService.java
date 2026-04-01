package com.emr.emrlite.service;

import com.emr.emrlite.dto.PatientDischargeDTO;
import com.emr.emrlite.model.EmployeeModel;
import com.emr.emrlite.model.PatientDischargeModel;
import com.emr.emrlite.repository.BedAssignmentRepository;
import com.emr.emrlite.repository.EmployeeRepository;
import com.emr.emrlite.repository.InstitutionUnitRepository;
import com.emr.emrlite.repository.PatientDischargeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientDischargeService {

    private final PatientDischargeRepository dischargeRepository;
    private final BedAssignmentRepository bedAssignmentRepository;
    private final InstitutionUnitRepository institutionUnitRepository;
    private final EmployeeRepository employeeRepository;

    public PatientDischargeService(PatientDischargeRepository dischargeRepository,
                                   BedAssignmentRepository bedAssignmentRepository,
                                   InstitutionUnitRepository institutionUnitRepository,
                                   EmployeeRepository employeeRepository) {
        this.dischargeRepository = dischargeRepository;
        this.bedAssignmentRepository = bedAssignmentRepository;
        this.institutionUnitRepository = institutionUnitRepository;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public PatientDischargeDTO saveDischarge(PatientDischargeDTO dto) {
        PatientDischargeModel model = PatientDischargeModel.builder()
                .patientId(dto.getPatientId())
                .visitId(dto.getVisitId())
                .dischargeDate(dto.getDischargeDate() != null ? dto.getDischargeDate() : LocalDateTime.now())
                .dischargeByDoctorId(dto.getDischargeByDoctorId())
                .dischargeBy(dto.getDischargeBy())
                .dischargeRemarks(dto.getDischargeRemarks())
                .createdAt(LocalDateTime.now())
                .build();

        dischargeRepository.save(model);

        // clear active bed assignments for this patient
        bedAssignmentRepository.findByPatientIdAndStatus(dto.getPatientId(), 1)
                .forEach(assignment -> {
                    assignment.setStatus(0);
                    assignment.setDischargedAt(model.getDischargeDate());
                    bedAssignmentRepository.save(assignment);
                    institutionUnitRepository.findById(assignment.getBedId()).ifPresent(bed -> {
                        bed.setIsOccupied(false);
                        institutionUnitRepository.save(bed);
                    });
                });

        dto.setId(model.getId());
        return dto;
    }

    public List<PatientDischargeDTO> getByPatientId(Long patientId) {
        return dischargeRepository.findByPatientId(patientId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PatientDischargeDTO getByVisitId(Long visitId) {
        return dischargeRepository.findByVisitId(visitId).map(this::toDTO).orElse(null);
    }

    private PatientDischargeDTO toDTO(PatientDischargeModel model) {
        PatientDischargeDTO dto = new PatientDischargeDTO();
        dto.setId(model.getId());
        dto.setPatientId(model.getPatientId());
        dto.setVisitId(model.getVisitId());
        dto.setDischargeDate(model.getDischargeDate());
        dto.setDischargeByDoctorId(model.getDischargeByDoctorId());
        dto.setDischargeBy(model.getDischargeBy());
        dto.setDischargeRemarks(model.getDischargeRemarks());
        dto.setCreatedAt(model.getCreatedAt());
        if (model.getDischargeByDoctorId() != null) {
            employeeRepository.findById(model.getDischargeByDoctorId()).ifPresent(emp ->
                dto.setDischargeDoctorName(emp.getFirstname() + " " + emp.getLastname()));
        }
        return dto;
    }
}
