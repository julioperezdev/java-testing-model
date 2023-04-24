package dev.julioperez.usingMocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class UsingMocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsingMocksApplication.class, args);
	}

}
