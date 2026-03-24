package com.emr.emrlite.repository;

import com.emr.emrlite.model.BedAssignmentModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BedAssignmentRepository extends JpaRepository<BedAssignmentModel, Long> {
    Optional<BedAssignmentModel> findByBedIdAndStatus(Long bedId, Integer status);
    List<BedAssignmentModel> findByPatientId(Long patientId);
    List<BedAssignmentModel> findByPatientIdAndStatus(Long patientId, Integer status);

    @Query(nativeQuery = true, value = """
        WITH RECURSIVE bed_path AS (
            SELECT iu.id AS bed_id, iu.name, iu.parent_id, iu.name AS path
            FROM institution_unit iu
            INNER JOIN bed_assignment ba ON ba.bed_id = iu.id
            WHERE ba.patient_id = :patientId AND ba.status = :status
            UNION ALL
            SELECT bp.bed_id, iu.name, iu.parent_id, CONCAT(iu.name, ' > ', bp.path)
            FROM institution_unit iu
            INNER JOIN bed_path bp ON iu.id = bp.parent_id
        )
        SELECT ba.id, ba.bed_id, ba.patient_id, ba.admitted_at, ba.discharged_at, ba.status,
               (SELECT path FROM bed_path bp2 WHERE bp2.bed_id = ba.bed_id AND bp2.parent_id IS NULL LIMIT 1) AS bed_path
        FROM bed_assignment ba
        WHERE ba.patient_id = :patientId AND ba.status = :status
    """)
    List<Object[]> findBedPathByPatientIdAndStatus(@Param("patientId") Long patientId, @Param("status") Integer status);
}
