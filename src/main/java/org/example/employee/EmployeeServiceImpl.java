package org.example.employee;

import java.util.List;
import java.util.Map;
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

    @Override
    public Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Map<Boolean, List<Employee>> partitionBySalary(List<Employee> employees, double threshold) {
        return employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > threshold));
    }

    @Override
    public Optional<Employee> findMaxSalary(List<Employee> employees) {
        return employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
    }

    @Override
    public Optional<Employee> findMinSalary(List<Employee> employees) {
        return employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
    }

    @Override
    public Map<String, Employee> collectToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getId, employee -> employee));
    }

    @Override
    public List<Employee> filterByGender(List<Employee> employees, String gender) {
        return employees.stream()
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Location, Double> averageSalaryByLocation(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getLocation,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    @Override
    public List<Employee> findByAddress(List<Employee> employees, String address) {
        return employees.stream()
                .filter(employee -> employee.getAddress().equalsIgnoreCase(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByName(List<Employee> employees, String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByDepartment(List<Employee> employees, Department department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findBySalaryRange(List<Employee> employees, double minSalary, double maxSalary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByAgeRange(List<Employee> employees, int minAge, int maxAge) {
        return employees.stream()
                .filter(employee -> employee.getAge() >= minAge && employee.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByProject(List<Employee> employees, Project project) {
        return employees.stream()
                .filter(employee -> employee.getProjects().contains(project))
                .collect(Collectors.toList());
    }


    @Override
    public List<Employee> findByLocationAndDepartment(List<Employee> employees, Location location, Department department) {
        return employees.stream()
                .filter(employee -> employee.getLocation().equals(location) && employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByLocationAndSalary(List<Employee> employees, Location location, double minSalary, double maxSalary) {
        return employees.stream()
                .filter(employee -> employee.getLocation().equals(location) && employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findByLocationAndAge(List<Employee> employees, Location location, int minAge, int maxAge) {
        return employees.stream()
                .filter(employee -> employee.getLocation().equals(location) && employee.getAge() >= minAge && employee.getAge() <= maxAge)
                .collect(Collectors.toList());
    }
}