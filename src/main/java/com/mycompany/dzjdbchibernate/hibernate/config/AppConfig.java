package com.mycompany.dzjdbchibernate.hibernate.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages="com.mycompany.dzjdbchibernate.hibernate.dao.classes.repositoryes")
@EnableTransactionManagement
public class AppConfig {
    
    @Bean
    public DataSource dataSource()
    {
        return new EmbeddedDatabaseBuilder()
                .setType(H2)
                .addScript("create.sql")
                .addScript("update.sql")
                .build();
    }//end dataSource
    
    @Bean
    public HibernateTransactionManager transactionManager()
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        
        htm.setSessionFactory(sessionFactory().getObject());
        
        return htm;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
        
        lsb.setDataSource(dataSource());
        lsb.setHibernateProperties(hibernateProperties());
        lsb.setPackagesToScan("com.mycompany.dzjdbchibernate.hibernate.model");
        
        return lsb;
    }
    
    @Bean
    public Properties hibernateProperties()
    {
        Properties properties = new Properties();
        
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.max fetch depth","3");
        properties.setProperty("hibernate. jdЬc. fetch _ size", "50");
        properties.setProperty("hibernate.jdЬc.batch_size", "10");
       // properties.setProperty("hibernate.show_sql", "true");
        
        return properties;
    }
}
