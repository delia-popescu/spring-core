package com.training.spring.core.injectingcollections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CollectionsBean {

    @Autowired
    private List<String> myList;

    @Autowired
    private Set<String> mySet;

    @Autowired
    private Map<Integer, String> myMap;

    @Autowired(required = false)
    private List<MyBean> myBeans;

    public void printMyList(){
        System.out.println("MyList: " + myList);
    }

    public void printMySet(){
        System.out.println("MySet: " + mySet);
    }

    public void printMyMap(){
        System.out.println("MyMap: "+ myMap);
    }

    public void printMyBeans(){
        System.out.println("MyBeans: "+ myBeans);
    }
}
