package com.example.EmployeesProject.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
            ArrayList<Employee> defaultUsers = new ArrayList<Employee>();
            defaultUsers.add(new Employee("Yosef","cohen","y@gmail.com"));
            defaultUsers.add(new Employee("david","moshe","david.abc@gmail.com"));
            defaultUsers.add(new Employee("amit","shalom","baba@gmail.com"));
            repository.saveAll(defaultUsers);
        };
    }
}
