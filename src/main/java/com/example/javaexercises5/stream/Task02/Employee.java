package com.example.javaexercises5.stream.Task02;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String lastName;
    private Sex sex;
    private int yearOfBirth;
    private Double salary;

    public void riseSalary() {
        salary += salary * 0.05;
    }

    enum Sex {
        MALE, FEMALE
    }
}
