package com.training.spring.core;

import com.training.spring.core.dependson.FileProcessor;
import com.training.spring.core.dependson.FileReader;
import com.training.spring.core.dependson.FileWriter;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.training.spring.core.dependson")
public class SpringCoreDependsOnApplicationContext {

    @Bean
    @DependsOn({"fileWriter", "fileReader"})
    public FileProcessor fileProcessor(){
        System.out.println("fileProcessor bean");
        return new FileProcessor();
    }

    @Bean
    public FileWriter fileWriter(){
        System.out.println("fileWriter bean");
        return new FileWriter();
    }


    @Bean
    public FileReader fileReader(){
        System.out.println("fileReader bean");
        return new FileReader();
    }

    public static void main(String[] args){
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext
                (SpringCoreDependsOnApplicationContext.class)) {
            FileProcessor fileProcessor = (FileProcessor)applicationContext.getBean("fileProcessor");
        }
    }
}
