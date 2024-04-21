package com.emr.emrlite.interceptor;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 8916265337043311745L;
	private static final Logger logger = LoggerFactory.getLogger(MultiTenantConnectionProviderImpl.class);
	private java.util.Map<Object, Object> datasources;

// public NHSMultiTenantConnectionProviderImpl(java.util.HashMap<String,Object> datasources) {
// this.datasources=datasources;
// }

	@Override
	protected DataSource selectAnyDataSource() {
		if (logger.isInfoEnabled()) {
			logger.info(
					"No mapped customer code  found from context so setting it to  NHSMultiTenantConnectionProviderImpl :: ENTERPRISE ");
		}
		return (DataSource) datasources.get("ENTERPRISE");
	}

	public java.util.Map<Object, Object> getDatasources() {
		return datasources;
	}

	public void setDatasources(java.util.Map<Object, Object> datasources) {
		this.datasources = datasources;
	}

	/*
	 * @Override protected DataSource selectDataSource(String tenantIdentifier) {
	 * if(logger.isInfoEnabled()){ logger.
	 * info("Selected DB for Hibernate tenant   NHSMultiTenantConnectionProviderImpl :: "
	 * + tenantIdentifier); } return (DataSource) datasources.get(tenantIdentifier);
	 * }
	 */

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		if (logger.isInfoEnabled()) {
			logger.info(
					"Selected DB for Hibernate tenant   NHSMultiTenantConnectionProviderImpl :: " + tenantIdentifier);
		}
		return (DataSource) datasources.get(tenantIdentifier);
	}

}