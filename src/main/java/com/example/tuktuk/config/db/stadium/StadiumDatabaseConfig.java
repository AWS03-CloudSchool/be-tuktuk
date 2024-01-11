package com.example.tuktuk.config.db.stadium;

import com.example.tuktuk.config.AppProfile;
import com.example.tuktuk.config.db.BasicDatabaseConfig;
import com.example.tuktuk.config.db.DataSourceType;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = StadiumDatabaseConfig.entityPackage,
        entityManagerFactoryRef = StadiumDatabaseConfig.entityManager,
        transactionManagerRef = StadiumDatabaseConfig.transactionManager
)
public class StadiumDatabaseConfig extends BasicDatabaseConfig {

    public static final String entityManager = "stadiumEntityManagerFactory";
    public static final String transactionManager = "stadiumTransactionManager";
    public static final String entityPackage = "com.example.tuktuk.domain.stadium";
    public static final DataSourceType dataSourceType = DataSourceType.STADIUM;
    public static final String SCHEMA_NAME = "stadium";


    public StadiumDatabaseConfig(Environment env) {
        super(env);
    }


    @Profile(AppProfile.NON_TEST)
    @Bean(name = entityManager)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier(StadiumDataSourceConfig.DATASOURCE) DataSource routeDataSource
    ) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(routeDataSource);
        entityManager.setJpaVendorAdapter(getJpaVendorAdaptor());
        entityManager.setJpaPropertyMap(getJpaPropertyMap(dataSourceType));
        entityManager.setPackagesToScan(StadiumDatabaseConfig.entityPackage);
        entityManager.setPersistenceUnitName(dataSourceType.getDataSourceSchemaName());

        return entityManager;

    }

    @Profile(AppProfile.TEST)
    @Bean(name = entityManager)
    public LocalContainerEntityManagerFactoryBean testEntityManagerFactory(
            @Qualifier(StadiumDataSourceConfig.TEST_DATASOURCE) DataSource testDataSource
    ) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(testDataSource);
        entityManager.setJpaVendorAdapter(getJpaVendorAdaptor());
        entityManager.setJpaPropertyMap(getJpaPropertyMap(dataSourceType));
        entityManager.setPackagesToScan(StadiumDatabaseConfig.entityPackage);
        entityManager.setPersistenceUnitName(dataSourceType.getDataSourceSchemaName());

        return entityManager;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier(StadiumDatabaseConfig.entityManager) EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
