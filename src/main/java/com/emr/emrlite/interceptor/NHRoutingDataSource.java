package com.emr.emrlite.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * The Class NHRoutingDataSource.
 */
public class NHRoutingDataSource extends AbstractRoutingDataSource {

	private static final Logger logger = LoggerFactory.getLogger(NHRoutingDataSource.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#
	 * determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		String tenantId = null;
		try {
			if (TenantContext.getCurrentTenant() != null) {

				tenantId = TenantContext.getCurrentTenant();
				logger.info("Tenant ID obtained: " + tenantId);
			} else {
				tenantId = "ENTERPRISE";
				logger.info("No mapped customer code  found from context so setting it to ::" + tenantId);
			}

		} catch (Exception e) {
			logger.info("in cb routing" + e.getMessage());
		}
		return tenantId;
	}

}