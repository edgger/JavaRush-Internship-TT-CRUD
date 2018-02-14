package guru.optimal.crud.config;

import guru.optimal.crud.entity.Book;
import guru.optimal.crud.service.TestBean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("guru.optimal.crud.dao"),
        @ComponentScan("guru.optimal.crud.service")
})
public class SpringConfig {
    @Autowired
    private Environment env;

    /*@Bean
    public TestBean getTestBean() {
        return new TestBean("Simple test");
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public Book getBook() {
        return new Book();
    }*/

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan("guru.optimal.crud.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        try {
            sessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactoryBean.getObject();
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driver"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.user"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
        properties.put(AvailableSettings.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        properties.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

}
