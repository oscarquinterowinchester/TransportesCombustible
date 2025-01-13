package com.appchoferes.nomina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(scanBasePackages = "com.appchoferes.nomina")
@CrossOrigin(origins = "*")
public class NominaApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(NominaApplication.class, args);
	}

}
