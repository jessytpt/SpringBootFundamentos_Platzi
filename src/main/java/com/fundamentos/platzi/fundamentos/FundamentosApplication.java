package com.fundamentos.platzi.fundamentos;

import com.fundamentos.platzi.fundamentos.bean.MyBean;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.fundamentos.component.ComponentDependency;
import com.fundamentos.platzi.fundamentos.entity.Employe;
import com.fundamentos.platzi.fundamentos.entity.User;
import com.fundamentos.platzi.fundamentos.pojo.UserPojo;
import com.fundamentos.platzi.fundamentos.repository.EmployeRepository;
import com.fundamentos.platzi.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeRepository employeRepository;

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
		//ejemplosAnteriores();
		//saveUsersInDataBase();
		//getInformationJpqlFromUder();
		saveEmploye();
		getEmployeEmeail();
	}

	/*private  void getInformationJpqlFromUder(){
		userRepository.findByUserEmail("user2@nttdata.com");
		LOGGER.info("Usiario con el metodo findByUserEmail "+
				userRepository.findByUserEmail("user8@nttdata.com")
				.orElseThrow(()->new RuntimeException("No se encontro el usuario")));
	}*/

	private void saveUsersInDataBase(){
		User user1 = new User("user1","user1@nttdata.com", LocalDate.of(2022,01,15));
		User user2 = new User("user2","user2@nttdata.com", LocalDate.of(2022,02,15));
		User user3 = new User("user3","user3@nttdata.com", LocalDate.of(2022,03,15));
		User user4 = new User("user4","user4@nttdata.com", LocalDate.of(2022,04,15));
		User user5 = new User("user5","user5@nttdata.com", LocalDate.of(2022,05,15));
		User user6 = new User("user6","user6@nttdata.com", LocalDate.of(2022,06,15));
		User user7 = new User("user7","user7@nttdata.com", LocalDate.of(2022,07,15));
		User user8 = new User("user8","user8@nttdata.com", LocalDate.of(2022,8,15));
		User user9= new User("user9","user9@nttdata.com", LocalDate.of(2022,9,15));
		User user10 = new User("user10","user10@nttdata.com", LocalDate.of(2022,10,15));

		List<User> userList = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		//List<User> userList = Arrays.asList(user1);
		//userList.stream().forEach(userRepository::save);
		userRepository.saveAll(userList);
	}

	private void saveEmploye(){
		Employe employe1 = new Employe("Jessenia","jessy@nttdata.com");
		Employe employe2 = new Employe("Nelson","nelson@nttdata.com");
		Employe employe3 = new Employe("Juan Pablo","juan@nttdata.com");
		Employe employe4 = new Employe("Santiago","santy@nttdata.com");

		List<Employe> employeList = Arrays.asList(employe1,employe2,employe3,employe4);
		employeRepository.saveAll(employeList);
	}
	private  void  getEmployeEmeail(){

		/*LOGGER.info("Empleado por email: "+ employeRepository.findByEmail_employee("juan@nttdata.com"));
						//.orElseThrow(()->new RuntimeException("No se encontro el empleado")));
*/
		System.out.println("EMPLOYEE EMAIL ");
		/*employeRepository.findAndSort("Santiago", Sort.by("id_employe").descending())
				.stream()
				.forEach(employe -> System.out.println(employe.getName_employee()));

		employeRepository.findByName_employee("Jessenia")
				.stream()
				.forEach(employe -> LOGGER.info("Usuario con query "+employe));
				*/
		employeRepository.findByNameLike("%user%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLike "+ user));

	}

	public void ejemplosAnteriores(){
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
