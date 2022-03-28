package com.fundamentos.platzi.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MyBeanWithWithDependencyImplement implements MyBeanWithDependency {

    Log LOGGER = LogFactory.getLog(MyBeanWithWithDependencyImplement.class);
    //@Autowired
    private MyOperation myOperation;

    public MyBeanWithWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresaso al metodo print printWithDependency");
        int number = 9;
        LOGGER.debug("El numero enviado como parametro a la dependencia oeration es: "+number);
        System.out.println(myOperation.sum(number));
        System.out.println("Un bean con otra dependencia");
    }
}
