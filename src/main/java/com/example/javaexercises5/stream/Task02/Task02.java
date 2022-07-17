package com.example.javaexercises5.stream.Task02;

import java.util.Arrays;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Adam", "Nowak", Employee.Sex.MALE, 1950, 1250D),
                new Employee("Marek", "Kubiak", Employee.Sex.MALE, 2000, 14500D),
                new Employee("Kamila", "Glik", Employee.Sex.FEMALE, 1990, 2250D),
                new Employee("Dominika", "Kołtoń", Employee.Sex.FEMALE, 1970, 125D),
                new Employee("Sandra", "Grzybek", Employee.Sex.FEMALE, 2000, 3000D)
                );

        employees.stream()
                .filter(employee -> employee.getLastName().startsWith("N"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println();
        employees.stream()
                .filter(e -> 2022 - e.getYearOfBirth() >= 30 && 2022 - e.getYearOfBirth() <= 45)
                .forEach(System.out::println);

        System.out.println();
        System.out.println();

        employees.stream()
                .filter(employee -> employee.getSex() == Employee.Sex.FEMALE)
                .filter(e -> 2022 - e.getYearOfBirth() >= 20 && 2022 - e.getYearOfBirth() <= 30)
                .filter(e -> e.getSalary() <= 3500)
                .forEach(Employee::riseSalary);

        System.out.println(employees);
    }
}
