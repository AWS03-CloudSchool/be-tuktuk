package com.example.tuktuk.config.db;

import com.example.tuktuk.config.AppProfile;
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
/*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = SoccerDatabaseConfig.entityPackage,
        entityManagerFactoryRef = SoccerDatabaseConfig.entityManager,
        transactionManagerRef = SoccerDatabaseConfig.transactionManager
)
*/
public class SoccerDatabaseConfig extends BasicDatabaseConfig {
    public SoccerDatabaseConfig(Environment env) {
        super(env);
    }
    /*
    public static final String entityManager = "soccerEntityManagerFactory";
    public static final String transactionManager = "soccerTransactionManager";
    public static final String entityPackage = "com.example.tuktuk";
    public static final DataSourceType dataSourceType = DataSourceType.SOCCER;

    @Profile(AppProfile.LOCAL)
    @Bean(name = entityManager)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier(SoccerDataSourceConfig.DATASOURCE) DataSource routeDataSource
    ) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(routeDataSource);
        entityManager.setJpaVendorAdapter(getJpaVendorAdaptor());
        entityManager.setJpaPropertyMap(getJpaPropertyMap(dataSourceType));
        entityManager.setPackagesToScan(SoccerDatabaseConfig.entityPackage);
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

    @Bean(name = transactionManager)
    public PlatformTransactionManager transactionManager(
            @Qualifier(SoccerDatabaseConfig.entityManager) EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
     */
}
