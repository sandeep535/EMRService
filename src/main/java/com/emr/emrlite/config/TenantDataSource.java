package com.emr.emrlite.config;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.emr.emrlite.interceptor.MultiTenantConnectionProviderImpl;
import com.emr.emrlite.interceptor.NHRoutingDataSource;
import com.emr.emrlite.model.DataSourceConfig;
import com.emr.emrlite.repository.DataSourceConfigRepository;

import jakarta.annotation.PostConstruct;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TenantDataSource implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<String, DataSource> dataSources = new HashMap<>();

    @Autowired
    private DataSourceConfigRepository configRepo;
    
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private MultiTenantConnectionProviderImpl multiTenantConnectionProviderImpl;

    public DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll() {
        List<DataSourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        Map<Object, Object> result1 = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
            result1.put(config.getName(), dataSource);
        }
        NHRoutingDataSource nhs = context.getBean(NHRoutingDataSource.class);
        nhs.setTargetDataSources(result1);
        nhs.afterPropertiesSet();
        multiTenantConnectionProviderImpl.setDatasources(result1);
        return result;
    }
    
    private DataSource createDataSource(String name) {
        DataSourceConfig config = configRepo.findByName(name);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            return ds;
        }
        return null;
    }

}