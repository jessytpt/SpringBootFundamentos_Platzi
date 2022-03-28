package com.fundamentos.platzi.fundamentos;

import com.fundamentos.platzi.fundamentos.bean.MyBean;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.component.ComponentDependency;
import com.fundamentos.platzi.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.fundamentos.platzi.fundamentos.component"})
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;

	@Autowired
	private MyBean myBean;

	@Autowired
	private MyBeanWithDependency myBeanWithDependency;

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	private UserPojo userPojo;

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
		System.out.println("Información personal: "+userPojo.getEmail()+" "+userPojo.getAge()+" "+userPojo.getPassword());
		try {
			//código que generq error
			int value = 10/0;
			LOGGER.info("Mi valor es: "+value);
		}catch (Exception e){
			//LOGGER.error("Esto es un error del aplicativo");	//imprimir error
			LOGGER.error("Esto es un error al dividir por cero"+e.getStackTrace());
		}

	}
}
