package com.emr.emrlite.service;

import com.emr.emrlite.dto.BedAssignmentDTO;
import com.emr.emrlite.dto.BedAssignmentDetailDTO;
import com.emr.emrlite.model.BedAssignmentModel;
import com.emr.emrlite.repository.BedAssignmentRepository;
import com.emr.emrlite.repository.InstitutionUnitRepository;
import com.emr.emrlite.repository.InstitutionUnitRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BedAssignmentService {

    private final BedAssignmentRepository bedAssignmentRepository;
    private final InstitutionUnitRepository institutionUnitRepository;

    public BedAssignmentService(BedAssignmentRepository bedAssignmentRepository,
                                InstitutionUnitRepository institutionUnitRepository) {
        this.bedAssignmentRepository = bedAssignmentRepository;
        this.institutionUnitRepository = institutionUnitRepository;
    }

    @Transactional
    public BedAssignmentModel assignBed(BedAssignmentDTO dto) {
        institutionUnitRepository.findById(dto.getBedId()).ifPresent(bed -> {
            bed.setIsOccupied(true);
            institutionUnitRepository.save(bed);
        });
        BedAssignmentModel assignment = BedAssignmentModel.builder()
                .bedId(dto.getBedId())
                .patientId(dto.getPatientId())
                .admittedAt(dto.getAdmittedAt() != null ? dto.getAdmittedAt() : LocalDateTime.now())
                .status(1)
                .createdAt(LocalDateTime.now())
                .build();
        return bedAssignmentRepository.save(assignment);
    }

    @Transactional
    public BedAssignmentModel dischargeBed(Long assignmentId) {
        BedAssignmentModel assignment = bedAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        assignment.setStatus(0);
        assignment.setDischargedAt(LocalDateTime.now());
        institutionUnitRepository.findById(assignment.getBedId()).ifPresent(bed -> {
            bed.setIsOccupied(false);
            institutionUnitRepository.save(bed);
        });
        return bedAssignmentRepository.save(assignment);
    }

    public List<BedAssignmentModel> getAssignmentsByPatient(Long patientId) {
        return bedAssignmentRepository.findByPatientId(patientId);
    }

    public List<BedAssignmentDetailDTO> getActiveAssignmentsByPatient(Long patientId) {
        return bedAssignmentRepository.findBedPathByPatientIdAndStatus(patientId, 1)
                .stream().map(row -> new BedAssignmentDetailDTO(
                        ((Number) row[0]).longValue(),
                        ((Number) row[1]).longValue(),
                        ((Number) row[2]).longValue(),
                        row[3] != null ? ((java.sql.Timestamp) row[3]).toLocalDateTime() : null,
                        row[4] != null ? ((java.sql.Timestamp) row[4]).toLocalDateTime() : null,
                        ((Number) row[5]).intValue(),
                        (String) row[6]
                )).collect(java.util.stream.Collectors.toList());
    }
}
