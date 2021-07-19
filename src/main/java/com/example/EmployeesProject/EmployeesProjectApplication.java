package com.example.EmployeesProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class EmployeesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesProjectApplication.class, args);
	}

}
