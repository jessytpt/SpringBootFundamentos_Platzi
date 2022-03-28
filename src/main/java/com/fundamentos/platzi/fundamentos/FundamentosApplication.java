package com.fundamentos.platzi.fundamentos;

import com.fundamentos.platzi.fundamentos.bean.MyBean;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.fundamentos.platzi.fundamentos.component"})
public class FundamentosApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;

	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBeanWithDependency myBeanWithDependency;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;

	/*
	public FundamentosApplication(ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
		System.out.println("Hola mundo");
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println("Mi nombre es: "+myBeanWithProperties.function());
	}
}
