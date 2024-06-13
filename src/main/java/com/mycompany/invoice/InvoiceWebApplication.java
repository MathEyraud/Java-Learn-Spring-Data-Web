package com.mycompany.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJdbcRepositories 	// Pas necessaire avec Spring-boot-data-jdbc
//@EnableJpaRepositories 	// Pas necessaire avec Spring-boot-data-jpa
public class InvoiceWebApplication {

	public static void main(String[] args) {

		// Permet de démarrer l'application
		SpringApplication.run(InvoiceWebApplication.class, args);

	}

}
