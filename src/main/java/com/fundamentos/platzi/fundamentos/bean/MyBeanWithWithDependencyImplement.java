package com.fundamentos.platzi.fundamentos.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MyBeanWithWithDependencyImplement implements MyBeanWithDependency {

    //@Autowired
    private MyOperation myOperation;

    public MyBeanWithWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 9;
        System.out.println(myOperation.sum(number));
        System.out.println("Un bean con otra dependencia");
    }
}
