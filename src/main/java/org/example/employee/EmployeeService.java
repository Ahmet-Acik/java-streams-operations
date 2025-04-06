package org.example.employee;

import java.util.List;
import java.util.Map;
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
    Map<Department, List<Employee>> groupByDepartment(List<Employee> employees);
    Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, double threshold);
    Optional<Employee> findMaxSalary(List<Employee> employees);
    Optional<Employee> findMinSalary(List<Employee> employees);
    Map<String, Employee> collectToMap(List<Employee> employees);
    List<Employee> filterByGender(List<Employee> employees, String gender);
    Map<Location, Double> averageSalaryByLocation(List<Employee> employees);
    List<Employee> findByAddress(List<Employee> employees, String address);//
    List<Employee> findByName(List<Employee> employees, String name);
//    List<Employee> findByDepartment(List<Employee> employees, Department department);
//    List<Employee> findBySalaryRange(List<Employee> employees, double minSalary, double maxSalary);
//    List<Employee> findByAgeRange(List<Employee> employees, int minAge, int maxAge);
//    List<Employee> findByProject(List<Employee> employees, Project project);
//    List<Employee> findByLocationAndDepartment(List<Employee> employees, Location location, Department department);
//    List<Employee> findByLocationAndSalary(List<Employee> employees, Location location, double minSalary, double maxSalary);
//    List<Employee> findByLocationAndAge(List<Employee> employees, Location location, int minAge, int maxAge);
//
