package com.example.tuktuk.config.db.stadium;

import com.example.tuktuk.config.db.DataSourceRole;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;

public class StadiumRouteDataSource extends AbstractRoutingDataSource {
    public StadiumRouteDataSource(Map<Object, Object> dataSourceMap) {
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
