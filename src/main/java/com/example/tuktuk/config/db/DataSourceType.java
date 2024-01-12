package com.example.tuktuk.config.db;

import lombok.Getter;

@Getter
public enum
DataSourceType {

    SOCCER(BasicDataSourceConfig.SOCCER, "app.datasource.soccer");

    private final String dataSourceSchemaName;

    private final String dataSourceProperty;

    DataSourceType(String dataSourceSchemaName, String dataSourceProperty) {
        this.dataSourceSchemaName = dataSourceSchemaName;
        this.dataSourceProperty = dataSourceProperty;
    }

}
