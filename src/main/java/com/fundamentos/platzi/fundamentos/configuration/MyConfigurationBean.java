package com.fundamentos.platzi.fundamentos.configuration;

import com.fundamentos.platzi.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Qualifier("myConfigurationBean")
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithWithDependencyImplement(myOperation);
    }
}
