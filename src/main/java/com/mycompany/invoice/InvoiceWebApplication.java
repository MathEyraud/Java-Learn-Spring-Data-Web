package com.mycompany.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
//@EnableJdbcRepositories // Pas necessaire avec Spring-boot-data-JDBC
public class InvoiceWebApplication {

	public static void main(String[] args) {

		// Permet de démarrer l'application
		SpringApplication.run(InvoiceWebApplication.class, args);

	}

}
