package com.fundamentos.platzi.fundamentos.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("componentTwoImplement")
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Yo soy la segunda implementación");
    }
}
