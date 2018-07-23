package com.training.spring.core.dependencyinjection.componentscan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class LombokComponentJdbcConnection {

    private String url;
    private String user;
    private String password;

}
