package com.fundamentos.platzi.fundamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
		System.out.println("Hola mundo");
	}

}