package com.training.spring.core;

import com.training.spring.core.injectiontypes.cdi.SomeCdiBusiness;
import com.training.spring.core.injectiontypes.cdi.SomeCdiDao2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringCoreCdiApplication {

    @Bean
    SomeCdiDao2 someCdiDao2(){
        SomeCdiDao2 someCdiDao = new SomeCdiDao2();
        return someCdiDao;
    }

    @Bean
    SomeCdiDao2 someCdiDao2Second(){
        SomeCdiDao2 someCdiDao = new SomeCdiDao2();
        return someCdiDao;
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SpringCoreCdiApplication.class)) {
            SomeCdiBusiness business = applicationContext.getBean(SomeCdiBusiness.class);

            System.out.println("Business component: " + business);
            System.out.println("Dao component: " + business.getSomeCdiDao());
            System.out.println("Dao component: " + business.getCdiDao());
        }
    }
}