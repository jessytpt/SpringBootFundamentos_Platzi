package com.fundamentos.platzi.fundamentos.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("componentImplement")
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi componente");
    }
}
