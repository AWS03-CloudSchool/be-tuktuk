package com.example.tuktuk.config.db;

import lombok.Getter;

@Getter
public enum DataSourceType {

    STADIUM(BasicDatasourceConfig.STADIUM, "app.datasource.stadium"),
    COURT(BasicDatasourceConfig.COURT, "app.datasource.court");

    private final String dataSourceSchemaName;

    private final String datasourceProperty;

    DataSourceType(String dataSourceSchemaName, String datasourceProperty) {
        this.dataSourceSchemaName = dataSourceSchemaName;
        this.datasourceProperty = datasourceProperty;
    }

}
