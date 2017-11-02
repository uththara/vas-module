package org.ucsc.ewa.vasModule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan("org.ucsc.ewa.vasModule.repository")
@EnableJpaRepositories("org.ucsc.ewa.vasModule.repository")
public class JpaConfig {

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        // gDickens: BOTH Persistence Unit and Packages to Scan are NOT compatible, persistenceUnit will win
        em.setPersistenceUnitName("user-module");
        em.setPackagesToScan("org.ucsc.ewa.vasModule");
        em.setJpaVendorAdapter(jpaVendorAdaper());
        em.afterPropertiesSet();
        return em.getObject();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdaper() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(Boolean.FALSE);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }


}
