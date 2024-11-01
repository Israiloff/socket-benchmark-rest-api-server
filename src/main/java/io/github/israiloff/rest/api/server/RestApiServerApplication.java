package io.github.israiloff.rest.api.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.israiloff")
public class RestApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiServerApplication.class, args);
	}

}
