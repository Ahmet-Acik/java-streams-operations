package org.example.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> filterByAge(List<Employee> employees, int age) {
        return employees.stream()
                .filter(employee -> employee.getAge() > age)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findFirstByLocation(List<Employee> employees, Location location) {
        return employees.stream()
                .filter(employee -> employee.getLocation().equals(location))
                .findFirst();
    }

    @Override
    public List<Employee> sortByName(List<Employee> employees) {
        return employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public double sumOfSalaries(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public List<Employee> filterByDepartment(List<Employee> employees, Department department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> filterByProject(List<Employee> employees, Project project) {
        return employees.stream()
                .filter(employee -> employee.getProjects().contains(project))
                .collect(Collectors.toList());
    }

    @Override
    public double averageSalaryByDepartment(List<Employee> employees, Department department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    @Override
    public long countByLocation(List<Employee> employees, Location location) {
        return employees.stream()
                .filter(employee -> employee.getLocation().equals(location))
                .count();
    }

    @Override
    public List<Employee> distinctByLocation(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Employee::getLocation, e -> e, (e1, e2) -> e1),
                        map -> map.values().stream().collect(Collectors.toList())
                ));
    }
}