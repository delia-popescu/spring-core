package com.training.spring.core.classpathfileload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class ClasspathFileLoad {

    @Value("classpath:data/data.txt")
    private Resource file;

    public String readFile1() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            return br.lines().collect(Collectors.joining("\n"));
        }
    }

    public String readFile2() throws IOException {
        ClassPathResource file = new ClassPathResource("data/data.txt", this.getClass().getClassLoader());
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            return br.lines().collect(Collectors.joining(","));
        }
    }

    public String readFile3() throws IOException {
        File file = ResourceUtils.getFile("classpath:data/data.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            return br.lines().collect(Collectors.joining("|"));
        }
    }

}
