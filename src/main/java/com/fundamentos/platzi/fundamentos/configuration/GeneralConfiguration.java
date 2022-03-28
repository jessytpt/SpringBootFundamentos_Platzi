package com.fundamentos.platzi.fundamentos.configuration;

import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Esta anotacion es para indicar que en este archivo van todas las configuraciones
public class GeneralConfiguration {
    @Value("${value.name}") //anotación para acceder a las propiedades que se definan en application.properties
    private String name; //PERO el valor de la anotaciòn debe ser guardado en una variable, en este caso en un STRING.

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, lastName);
    }
}
