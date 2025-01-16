package com.appchoferes.nomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.appchoferes.nomina")
@EnableJpaRepositories(basePackages = "com.appchoferes.nomina.repositories.lorasdb")
@EntityScan(basePackages = "com.appchoferes.nomina.models.lorasdb")
@CrossOrigin(origins = "*")
public class NominaApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(NominaApplication.class, args);
	}

}
