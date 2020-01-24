package com.exercize.sela;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import models.Template;

@SpringBootApplication
@ComponentScan(basePackages = "controllers")
public class SelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelaApplication.class, args);
	}

	@Bean
	public List<Template> cardStorage(){  
		return new ArrayList<Template>(); 
	}
}
