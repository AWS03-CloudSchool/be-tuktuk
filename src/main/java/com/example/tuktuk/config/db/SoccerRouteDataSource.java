package com.example.tuktuk.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;

public class SoccerRouteDataSource extends AbstractRoutingDataSource {
    public SoccerRouteDataSource(Map<Object, Object> dataSourceMap) {
        super.setTargetDataSources(dataSourceMap);
        super.setDefaultTargetDataSource(dataSourceMap.get(DataSourceRole.READ_WRITE));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceRole dataSourceRole = TransactionSynchronizationManager.isCurrentTransactionReadOnly()
                ? DataSourceRole.READ_ONLY : DataSourceRole.READ_WRITE;

        return dataSourceRole;
    }
}
