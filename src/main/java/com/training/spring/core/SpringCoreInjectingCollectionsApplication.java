package com.training.spring.core;


import com.training.spring.core.injectingcollections.CollectionsBean;
import com.training.spring.core.injectingcollections.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.*;

@Configuration
@ComponentScan("com.training.spring.core.injectingcollections")
public class SpringCoreInjectingCollectionsApplication {

    @Bean
    public List<String> myList(){
        return Arrays.asList("Ana", "Ion", "Gigi");
    }

    @Bean
    public Set<String> mySet(){
        Set<String> set = new HashSet<>();
        set.add("Ana");
        set.add("Ion");
        set.add("Gigi");
        return set;
    }

    @Bean
    public Map<Integer, String> myMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ana");
        map.put(2, "Ion");
        map.put(3, "Gigi");
        return map;
    }

    @Bean
    @Order(1)
    public MyBean firstMyBean(){
        return new MyBean("Ana");
    }

    @Bean
    @Order(2)
    public MyBean secondMyBean(){
        return new MyBean("Ion");
    }

    @Bean
    @Order(3)
    public MyBean thirdMyBean(){
        return new MyBean("Gigi");
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCoreInjectingCollectionsApplication.class)) {
            CollectionsBean collectionsBean = applicationContext.getBean(CollectionsBean.class);
            collectionsBean.printMyList();
            collectionsBean.printMySet();
            collectionsBean.printMyMap();
            collectionsBean.printMyBeans();
        }
    }
}
