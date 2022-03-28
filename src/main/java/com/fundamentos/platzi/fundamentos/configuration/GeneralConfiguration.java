package com.fundamentos.platzi.fundamentos.configuration;

import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.platzi.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration //Esta anotacion es para indicar que en este archivo van todas las configuraciones
@EnableConfigurationProperties(UserPojo.class) //indica que la clase User pojo es la que tiene propiedades dentro de la aplicación
                                                // una vez que se declare a la clase Pojo ya puede ser inyectada en cualquier cosa
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

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:men:testdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
