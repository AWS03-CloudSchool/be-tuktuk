package com.example.tuktuk.config.db;

import com.example.tuktuk.config.AppProfile;
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

//@Configuration
public class SoccerDataSourceConfig extends BasicDataSourceConfig {
    public SoccerDataSourceConfig(Environment env) {
        super(env);
    }
    /*
    public static final String DATASOURCE = "soccerDataSource";
    public static final String ROUTE_DATASOURCE = "soccerRouteDataSource";
    public static final String RW_DATASOURCE = "soccerRwDataSource";
    public static final String RO_DATASOURCE = "soccerRoDataSource";
    public static final String TEST_DATASOURCE = "soccerTestDataSource";
    public static final DataSourceType dataSourceType = DataSourceType.SOCCER;

    @Profile(AppProfile.LOCAL)
    @Bean(name = DATASOURCE)
    public DataSource dataSource(
            @Qualifier(SoccerDataSourceConfig.ROUTE_DATASOURCE) DataSource routeDataSource
    ) {
        return new LazyConnectionDataSourceProxy(routeDataSource);
    }

    @Profile(AppProfile.LOCAL)
    @Bean(name = ROUTE_DATASOURCE)
    public DataSource routingDataSource(
            @Qualifier(SoccerDataSourceConfig.RW_DATASOURCE) DataSource rwDataSource,
            @Qualifier(SoccerDataSourceConfig.RO_DATASOURCE) DataSource roDataSource
    ) {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceRole.READ_WRITE, rwDataSource);
        dataSourceMap.put(DataSourceRole.READ_ONLY, roDataSource);

        return new SoccerRouteDataSource(dataSourceMap);
    }

    @Profile(AppProfile.LOCAL)
    @Bean(name = RW_DATASOURCE)
    public DataSource rwDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(getJdbcUrl(dataSourceType, DataSourceRole.READ_WRITE));
        dataSource.setDriverClassName(getDriverClassName(dataSourceType));
        dataSource.setUsername(getUsername(dataSourceType));
        dataSource.setPassword(getPassword(dataSourceType));

        return dataSource;
    }

    @Profile(AppProfile.LOCAL)
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
    */
}
