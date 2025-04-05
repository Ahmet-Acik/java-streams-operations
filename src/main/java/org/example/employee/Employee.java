package org.example.employee;

import java.util.List;

public class Employee {
    private final String id;
    private final String name;
    private final int age;
    private final String gender;
    private final String address;
    private final String department;
    private final double salary;
    private final String location;
    private final List<String> projects;

    public Employee(String id, String name, int age, String gender, String address, String department, double salary, String location, List<String> projects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.salary = salary;
        this.location = location;
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', age=" + age + ", gender='" + gender + "', address='" + address + "', department='" + department + "', salary=" + salary + ", location='" + location + "', projects=" + projects + "}";
    }
}