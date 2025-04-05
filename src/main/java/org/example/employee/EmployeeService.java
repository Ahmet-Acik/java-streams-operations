package org.example.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> filterByAge(List<Employee> employees, int age);
    List<String> getNames(List<Employee> employees);
    Optional<Employee> findFirstByLocation(List<Employee> employees, Location location);
    List<Employee> sortByName(List<Employee> employees);
    double sumOfSalaries(List<Employee> employees);
    List<Employee> filterByDepartment(List<Employee> employees, Department department);
    List<Employee> filterByProject(List<Employee> employees, Project project);
    double averageSalaryByDepartment(List<Employee> employees, Department department);
    long countByLocation(List<Employee> employees, Location location);
    List<Employee> distinctByLocation(List<Employee> employees);
}