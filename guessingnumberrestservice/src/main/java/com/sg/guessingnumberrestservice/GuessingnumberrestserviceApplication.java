package com.sg.guessingnumberrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GuessingnumberrestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuessingnumberrestserviceApplication.class, args);
	}

}
