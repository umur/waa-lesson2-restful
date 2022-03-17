package edu.miu.restful;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

	//TODO Should we add a configuration file for this???

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
