package com.emr.emrlite.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.emr.emrlite.interceptor.MultiTenantConnectionProviderImpl;
import com.emr.emrlite.interceptor.NHRoutingDataSource;
import com.emr.emrlite.interceptor.TenantSchemaResolver;

@Configuration
public class HibernateConfig {

	@Autowired
	private JpaProperties jpaProperties;

	@Bean
	JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		Map<String, Object> jpaPropertiesMap = new HashMap<>(jpaProperties.getProperties());
		jpaPropertiesMap.put("hibernate.multiTenancy", "DATABASE");
		jpaPropertiesMap.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, getMultiTenantConnectionProvider());
		jpaPropertiesMap.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, TenantSchemaResolver.class);
		jpaPropertiesMap.put(Environment.FORMAT_SQL, true);
		jpaPropertiesMap.put(Environment.SHOW_SQL, true);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJpaVendorAdapter(this.jpaVendorAdapter());
		em.setDataSource(dataSourceRouting());
		em.setPackagesToScan("com.emr.emrlite*");
		
		em.setJpaPropertyMap(jpaPropertiesMap);
		return em;
	}
	
//	@Bean
//	@Primary
//    public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
//        return new TenantSchemaResolver();
//    }
//	
//	@Bean
//    public MultiTenantConnectionProvider multiTenantConnectionProvider() {
//        return new MultiTenantConnectionProviderImpl();
//    }
	
	

	@Bean
	public MultiTenantConnectionProviderImpl getMultiTenantConnectionProvider() {
		MultiTenantConnectionProviderImpl nhsmtcpi = new MultiTenantConnectionProviderImpl();
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("ENTERPRISE", dataSourceEnterprise());
		nhsmtcpi.setDatasources(targetDataSources);
		return nhsmtcpi;
	}
	
	@Bean(name = "NHRoutingDataSource")
	public NHRoutingDataSource dataSourceRouting() {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("ENTERPRISE", dataSourceEnterprise());

		NHRoutingDataSource clientRoutingDatasource = new NHRoutingDataSource();
		clientRoutingDatasource.setTargetDataSources(targetDataSources);
		clientRoutingDatasource.setDefaultTargetDataSource(dataSourceEnterprise());
		return clientRoutingDatasource;
	}
	
	@Qualifier("enterpriseDS")
	@Primary
	public DataSource dataSourceEnterprise() {
	DataSource a = dataSourceEnterpriseProperties().initializeDataSourceBuilder().build();
	return a;
	}

	@Bean
	@Primary
	@Qualifier("enterpriseProp")
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties dataSourceEnterpriseProperties() {
	return new DataSourceProperties();
	}

}