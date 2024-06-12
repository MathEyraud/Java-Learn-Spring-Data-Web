package com.mycompany.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class InvoiceWebApplication {

	public static void main(String[] args) {

		// Permet de démarrer l'application
		SpringApplication.run(InvoiceWebApplication.class, args);

	}

}
