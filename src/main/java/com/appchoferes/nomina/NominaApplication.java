package com.appchoferes.nomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.appchoferes.nomina")
@SpringBootApplication
public class NominaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NominaApplication.class, args);
	}

}
