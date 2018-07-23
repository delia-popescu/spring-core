package com.training.spring.core;

import com.training.spring.core.classpathfileload.ClasspathFileLoad;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("com.training.spring.core.classpathfileload")
public class SpringCoreClasspathFileLoad {

    public static void main(String[] args) throws IOException {

        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringCoreClasspathFileLoad.class)) {
            ClasspathFileLoad bean = appContext.getBean(ClasspathFileLoad.class);
            System.out.println(bean.readFile1());
            System.out.println(bean.readFile2());
            System.out.println(bean.readFile3());
        }
    }


}
