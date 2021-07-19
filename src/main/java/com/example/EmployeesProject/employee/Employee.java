package com.example.EmployeesProject.employee;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
//    @Id
//    @SequenceGenerator(
//            name = "employee_sequence",
//            sequenceName = "employee_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "employee_sequence"
//    )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    private String firstName;

    private String lastName;

    private String email;

    public Employee(String firstName,
                    String lastName,
                    String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Employee(){
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + employee_id +
                ", first name'" + firstName + '\'' +
                ", last name'" + lastName + '\'' +
                ", email'" + firstName + '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployeeId(){
        return employee_id;
    }
}

