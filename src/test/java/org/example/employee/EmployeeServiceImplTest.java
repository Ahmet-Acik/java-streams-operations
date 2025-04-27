package org.example.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeService employeeService;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
        employees = Arrays.asList(
                new Employee("1", "Alice", 30, "Female", "123 Main St", Department.ENGINEERING, 90000, Location.NEW_YORK, Arrays.asList(Project.CLOUD_MIGRATION)),
                new Employee("2", "Bob", 25, "Male", "456 Elm St", Department.MARKETING, 60000, Location.SAN_FRANCISCO, Arrays.asList(Project.MOBILE_APP_DEVELOPMENT)),
                new Employee("3", "Charlie", 35, "Male", "789 Oak St", Department.ENGINEERING, 120000, Location.NEW_YORK, Arrays.asList(Project.AI_RESEARCH))
        );
    }

    @AfterEach
    void tearDown() {
        employeeService = null;
        employees = null;
    }

    @Test
    void filterByAge() {
        List<Employee> result = employeeService.filterByAge(employees, 30);
        assertEquals(1, result.size());
        assertEquals("Charlie", result.get(0).getName());
    }

    @Test
    void getNames() {
        List<String> result = employeeService.getNames(employees);
        assertEquals(3, result.size());
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("Bob"));
        assertTrue(result.contains("Charlie"));
    }

    @Test
    void findFirstByLocation() {
        Optional<Employee> result = employeeService.findFirstByLocation(employees, Location.NEW_YORK);
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getName());
    }

    @Test
    void sortByName() {
        List<Employee> result = employeeService.sortByName(employees);
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
        assertEquals("Charlie", result.get(2).getName());
    }

    @Test
    void sumOfSalaries() {
        double result = employeeService.sumOfSalaries(employees);
        assertEquals(270000, result);
    }

    @Test
    void filterByDepartment() {
        List<Employee> result = employeeService.filterByDepartment(employees, Department.ENGINEERING);
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Charlie", result.get(1).getName());
    }

    @Test
    void filterByProject() {
        List<Employee> result = employeeService.filterByProject(employees, Project.CLOUD_MIGRATION);
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void averageSalaryByDepartment() {
        double result = employeeService.averageSalaryByDepartment(employees, Department.ENGINEERING);
        assertEquals(105000, result);
    }

    @Test
    void countByLocation() {
        long result = employeeService.countByLocation(employees, Location.NEW_YORK);
        assertEquals(2, result);
    }

    @Test
    void distinctByLocation() {
        List<Employee> result = employeeService.distinctByLocation(employees);
        assertEquals(2, result.size());
    }

    @Test
    void groupByDepartment() {
        Map<Department, List<Employee>> result = employeeService.groupByDepartment(employees);
        assertEquals(2, result.get(Department.ENGINEERING).size());
        assertEquals(1, result.get(Department.MARKETING).size());
    }

    @Test
    void partitionBySalary() {
        Map<Boolean, List<Employee>> result = employeeService.partitionBySalary(employees, 80000);
        assertEquals(2, result.get(true).size());
        assertEquals(1, result.get(false).size());
    }

    @Test
    void findMaxSalary() {
        Optional<Employee> result = employeeService.findMaxSalary(employees);
        assertTrue(result.isPresent());
        assertEquals("Charlie", result.get().getName());
    }

    @Test
    void findMinSalary() {
        Optional<Employee> result = employeeService.findMinSalary(employees);
        assertTrue(result.isPresent());
        assertEquals("Bob", result.get().getName());
    }

    @Test
    void collectToMap() {
        Map<String, Employee> result = employeeService.collectToMap(employees);
        assertEquals(3, result.size());
        assertEquals("Alice", result.get("1").getName());
    }

    @Test
    void filterByGender() {
        List<Employee> result = employeeService.filterByGender(employees, "Female");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void averageSalaryByLocation() {
        Map<Location, Double> result = employeeService.averageSalaryByLocation(employees);
        assertEquals(105000, result.get(Location.NEW_YORK));
    }

    @Test
    void findByAddress() {
        List<Employee> result = employeeService.findByAddress(employees, "123 Main St");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void findByName() {
        List<Employee> result = employeeService.findByName(employees, "Alice");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void findBySalaryRange() {
        List<Employee> result = employeeService.findBySalaryRange(employees, 60000, 100000);
        assertEquals(2, result.size());
    }

    @Test
    void findByAgeRange() {
        List<Employee> result = employeeService.findByAgeRange(employees, 25, 35);
        assertEquals(3, result.size());
    }

    @Test
    void findByLocationAndDepartment() {
        List<Employee> result = employeeService.findByLocationAndDepartment(employees, Location.NEW_YORK, Department.ENGINEERING);
        assertEquals(2, result.size());
    }

    @Test
    void findByLocationAndSalary() {
        List<Employee> result = employeeService.findByLocationAndSalary(employees, Location.NEW_YORK, 60000, 100000);
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void findByLocationAndAge() {
        List<Employee> result = employeeService.findByLocationAndAge(employees, Location.NEW_YORK, 25, 35);
        assertEquals(2, result.size());

        Employee employee = new Employee("1", "Alice", 30, "Female", "123 Main St", Department.ENGINEERING, 90000, Location.NEW_YORK, Arrays.asList(Project.CLOUD_MIGRATION));
        BiPredicate<Employee, Integer> agePredicate = (emp, age) -> emp.getAge() > age;

        boolean abc = agePredicate.test(employee, 25); // Returns true because 30 > 25
    }
}