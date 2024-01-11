package com.example.tuktuk.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class BasicDatasourceConfig {

    protected final Environment env;

    //Multiple-Database 스키마 목록
    public static final String STADIUM = "stadium";
    public static final String COURT = "court";

    public BasicDatasourceConfig(Environment env) {
        this.env = env;
    }

    protected String getDriverClassName(final DataSourceType datasourceType) {
        final String driverClassName = datasourceType.getDatasourceProperty() + ".driverClassName";
        return env.getProperty(driverClassName);
    }

    protected String getJdbcUrl(final DataSourceType datasourceType,)
}
