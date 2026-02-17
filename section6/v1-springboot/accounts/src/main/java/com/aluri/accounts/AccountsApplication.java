package com.aluri.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title="Accounts microservice REST API Documentation",
				description = "Eazy Bank Accounts microservices",
				version = "v1",
				contact = @Contact(
						name = "Akhil Aluri",
						email = "akhil258@gmail.com",
						url = "https://amazon.in"
				),
				license = @License(
						name = "Apache 2.0",
						url = "asfd.com"
				)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
