package com.blogverse.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.blogverse")
class WebMvcViewResolver implements WebMvcConfigurer {

    // Setting view resolvers properties to handle the client request
    @Bean
    public InternalResourceViewResolver getResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // Creating datasource bean and adding datasource properties
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/blogverse");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    // creating properties object and set hibernate properties
    @Bean
    public Properties getProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);
        return props;
    }

    // creating factory object and setting all properties
    @Bean
    public LocalSessionFactoryBean getFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getDataSource());
        factory.setHibernateProperties(getProperties());
        factory.setPackagesToScan("com.blogverse.entity");
        return factory;
    }

    // creating hibernate template bean with factory bean refference
    @Bean
    public HibernateTemplate getTemplate() {
        return new HibernateTemplate(getFactory().getObject());
    }

    // creating transaction manager onject and setting factory properties
    @Bean
    public HibernateTransactionManager getTransaction() {
        return new HibernateTransactionManager(getFactory().getObject());
    }

    // handling static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Serve resources from the WEB-INF directory
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/resources/static/");
    }

}