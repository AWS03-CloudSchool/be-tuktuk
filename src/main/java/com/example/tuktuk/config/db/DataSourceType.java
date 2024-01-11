package com.example.tuktuk.config.db;

import lombok.Getter;

@Getter
public enum DataSourceType {

    STADIUM(BasicDataSourceConfig.STADIUM, "app.datasource.stadium"),
    COURT(BasicDataSourceConfig.COURT, "app.datasource.court");

    private final String dataSourceSchemaName;

    private final String dataSourceProperty;

    DataSourceType(String dataSourceSchemaName, String dataSourceProperty) {
        this.dataSourceSchemaName = dataSourceSchemaName;
        this.dataSourceProperty = dataSourceProperty;
    }

}
