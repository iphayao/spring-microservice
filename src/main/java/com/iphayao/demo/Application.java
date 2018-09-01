package com.iphayao.demo;

import com.iphayao.demo.customer.Customer;
import com.iphayao.demo.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("John", "Doe"));
			repository.save(new Customer("Jack", "Doe"));
			repository.save(new Customer("Jane", "Doe"));
			repository.save(new Customer("Baby", "Doe"));

//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for(Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
		};
	}
}
