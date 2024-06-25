package com.mycompany.invoice;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableJdbcRepositories 	// Pas necessaire avec Spring-boot-data-jdbc
//@EnableJpaRepositories 	// Pas necessaire avec Spring-boot-data-jpa
public class InvoiceWebApplication {

	public static void main(String[] args) {
		// Permet de démarrer l'application
		SpringApplication.run(InvoiceWebApplication.class, args);
	}

	// Permet de nullifier les proxy
	@Bean
	public Hibernate5JakartaModule datatypeHibernateModule(){
		return new Hibernate5JakartaModule();
	}

}