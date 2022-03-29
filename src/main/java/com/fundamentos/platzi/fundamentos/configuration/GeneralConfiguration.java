package com.fundamentos.platzi.fundamentos.configuration;

import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.platzi.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration //Esta anotacion es para indicar que en este archivo van todas las configuraciones
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class) //indica que la clase User pojo es la que tiene propiedades dentro de la aplicación
public class GeneralConfiguration {
    @Value("${value.name}") //anotación para acceder a las propiedades que se definan en application.properties
    private String name; //PERO el valor de la anotaciòn debe ser guardado en una variable, en este caso en un STRING.

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(name, lastName);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
