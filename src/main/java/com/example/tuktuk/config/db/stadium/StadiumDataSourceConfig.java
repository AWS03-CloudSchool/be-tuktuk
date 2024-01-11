package com.example.tuktuk.config.db.stadium;

import com.example.tuktuk.config.AppProfile;
import com.example.tuktuk.config.db.BasicDataSourceConfig;
import com.example.tuktuk.config.db.DataSourceRole;
import com.example.tuktuk.config.db.DataSourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class StadiumDataSourceConfig extends BasicDataSourceConfig {

    public static final String DATASOURCE = "stadiumDataSource";
    public static final String ROUTE_DATASOURCE = "stadiumRouteDataSource";
    public static final String RW_DATASOURCE = "stadiumRwDataSource";
    public static final String RO_DATASOURCE = "stadiumRoDataSource";
    public static final String TEST_DATASOURCE = "stadiumTestDataSource";
    public static final DataSourceType dataSourceType = DataSourceType.STADIUM;

    public StadiumDataSourceConfig(Environment env) {
        super(env);
    }




}
