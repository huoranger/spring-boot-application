package com.huoranger.handler;
import com.huoranger.utils.DatasourceContext;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

public class DynamicDatasourceHandler extends AbstractRoutingDataSource{

    public DynamicDatasourceHandler(DataSource defauleDatasource, Map<String, HikariDataSource> dynamicDatasource) {
        super.setDefaultTargetDataSource(defauleDatasource);
        super.setTargetDataSources(Collections.unmodifiableMap(dynamicDatasource));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceContext.getDataSourceType();
    }
}
