package com.aws;


import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App  extends SpringBootServletInitializer
{
    public static void main ( String[] args )
    {
    	
        SpringApplication.run(App.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
    /* this is used to integrate the hibernate with springboot Application */
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }
    
   /* @Bean
    public SessionFactory sessionFactory(EntityManager em) {
        //return new HibernateJpaSessionFactoryBean();
    	em.
    }*/

    }
