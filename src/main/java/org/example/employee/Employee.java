package org.example.employee;

import java.util.List;

public class Employee {
    private final String id;
    private final String name;
    private final int age;
    private final String gender;
    private final String address;
    private final Department department;
    private final double salary;
    private final Location location;
    private final List<Project> projects;

    public Employee(String id, String name, int age, String gender, String address, Department department, double salary, Location location, List<Project> projects) {
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

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Location getLocation() {
        return location;
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', age=" + age + ", gender='" + gender + "', address='" + address + "', department='" + department + "', salary=" + salary + ", location='" + location + "', projects=" + projects + "}";
    }
}