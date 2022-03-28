package com.fundamentos.platzi.fundamentos.bean;

import org.springframework.stereotype.Component;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private String name;
    private String lastName;

    public MyBeanWithPropertiesImplement(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String function() {
        return name+" - "+lastName;
    }
}
