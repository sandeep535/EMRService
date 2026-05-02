package com.emr.emrlite.repository;

import com.emr.emrlite.model.InvalidatedTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedTokenModel, Long> {

    boolean existsByToken(String token);

    List<InvalidatedTokenModel> findByExpiryBefore(Date now);

    @Modifying
    @Transactional
    void deleteByExpiryBefore(Date now);
}
