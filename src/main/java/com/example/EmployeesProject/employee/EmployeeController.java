package com.example.EmployeesProject.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("/getEmployeeByEmail")
    public Employee getEmployeeByEmail(@RequestParam("email") String email){
        return employeeService.getEmployeeByEmail(email);
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
                @PathVariable("employeeId") Integer employeeId,
                @RequestParam(required = false) String first_name,
                @RequestParam(required = false) String last_name,
                @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId,first_name,last_name,email);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(
            @PathVariable("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }

}
