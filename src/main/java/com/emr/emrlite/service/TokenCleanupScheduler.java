package com.emr.emrlite.service;

import com.emr.emrlite.interceptor.TenantContext;
import com.emr.emrlite.model.DataSourceConfig;
import com.emr.emrlite.repository.DataSourceConfigRepository;
import com.emr.emrlite.repository.InvalidatedTokenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TokenCleanupScheduler {

    private static final Logger log = LoggerFactory.getLogger(TokenCleanupScheduler.class);

    @Autowired
    private InvalidatedTokenRepository invalidatedTokenRepository;

    @Autowired
    private DataSourceConfigRepository dataSourceConfigRepository;

    @Scheduled(cron = "${app.token.cleanup.cron}")
    public void cleanupExpiredTokens() {
        log.info("Token cleanup scheduler started");

        // runs on ENTERPRISE/admin datasource as TenantContext is null here
        List<DataSourceConfig> tenants = dataSourceConfigRepository.findAll();
        log.info("Found {} tenant(s) to process", tenants.size());

        int totalCleaned = 0;

        for (DataSourceConfig tenant : tenants) {
            String tenantName = tenant.getName();
            try {
                TenantContext.setCurrentTenant(tenantName);

                Date now = new Date();
                int count = invalidatedTokenRepository.findByExpiryBefore(now).size();
                invalidatedTokenRepository.deleteByExpiryBefore(now);

                totalCleaned += count;
                log.info("Tenant [{}] - deleted {} expired token(s)", tenantName, count);

            } catch (Exception e) {
                log.error("Tenant [{}] - cleanup failed: {}", tenantName, e.getMessage());
            } finally {
                TenantContext.clear();
            }
        }

        log.info("Token cleanup complete - total deleted: {} across {} tenant(s)", totalCleaned, tenants.size());
    }
}
