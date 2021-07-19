package com.example.EmployeesProject.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).orElseThrow(() -> new IllegalStateException("User with email: " + email + " not exist"));
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeByEmail.isPresent()) {
            throw new IllegalStateException("Email is taken");
        } else {
            employeeRepository.save(employee);
        }
    }

    // allow you to update without use repository!
    @Transactional
    public void updateEmployee(Integer employeeId, String first_name, String last_name, String email) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException("User with id: " + employeeId.toString() + " not exist"));
        if (first_name != null && first_name.length() > 0 && !first_name.equals(employee.getEmail())) {
            employee.setFirstName(first_name);
        }
        if (last_name != null && last_name.length() > 0 && !last_name.equals(employee.getEmail())) {
            employee.setLastName(last_name);
        }
        if (email != null && email.length() > 0 && !email.equals(employee.getEmail())) {
            employee.setEmail(email);
        }
    }


    public void deleteEmployee(Integer employeeId) {
        boolean exist = employeeRepository.existsById(employeeId);
        if (!exist) {
            throw new IllegalStateException("User id: " + employeeId.toString() + " not exist");
        }
        employeeRepository.deleteById(employeeId);
    }
}
