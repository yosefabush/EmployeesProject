package com.example.EmployeesProject.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Query("SELECT s FROM Employee s where s.email=?1")

    // select * from Employee where email = ?
    Optional<Employee> findEmployeeByEmail(String email);
}
