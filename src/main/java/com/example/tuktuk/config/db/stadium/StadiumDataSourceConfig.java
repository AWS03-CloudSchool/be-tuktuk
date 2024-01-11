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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

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

    @Profile(AppProfile.NON_TEST)
    @Bean(name = DATASOURCE)
    public DataSource dataSource(
            @Qualifier(StadiumDataSourceConfig.ROUTE_DATASOURCE) DataSource routeDataSource
    ) {
        return new LazyConnectionDataSourceProxy(routeDataSource);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = ROUTE_DATASOURCE)
    public DataSource routingDataSource(
            @Qualifier(StadiumDataSourceConfig.RW_DATASOURCE) DataSource rwDataSource,
            @Qualifier(StadiumDataSourceConfig.RO_DATASOURCE) DataSource roDataSource
    ) {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceRole.READ_WRITE, rwDataSource);
        dataSourceMap.put(DataSourceRole.READ_ONLY, roDataSource);

        return new StadiumRouteDataSource(dataSourceMap);
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = RW_DATASOURCE)
    public DataSource rwDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_WRITE));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }

    @Profile(AppProfile.NON_TEST)
    @Bean(name = RO_DATASOURCE)
    public DataSource roDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_ONLY));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }


    @Profile(AppProfile.TEST)
    @Bean(name = TEST_DATASOURCE)
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.TEST_ONLY));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }


}
