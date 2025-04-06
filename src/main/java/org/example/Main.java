package org.example;

import org.example.employee.*;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("1", "Alice Johnson", 30, "Female", "123 Main St", Department.ENGINEERING, 90000, Location.NEW_YORK, Arrays.asList(Project.CLOUD_MIGRATION, Project.DATA_ANALYTICS)),
                new Employee("2", "Bob Smith", 25, "Male", "456 Elm St", Department.MARKETING, 60000, Location.SAN_FRANCISCO, Arrays.asList(Project.MOBILE_APP_DEVELOPMENT)),
                new Employee("3", "Charlie Brown", 35, "Male", "789 Oak St", Department.ENGINEERING, 120000, Location.NEW_YORK, Arrays.asList(Project.CYBER_SECURITY, Project.AI_RESEARCH)),
                new Employee("4", "David Wilson", 40, "Male", "101 Pine St", Department.HR, 70000, Location.LOS_ANGELES, Arrays.asList(Project.DEVOPS_AUTOMATION)),
                new Employee("5", "Eve Davis", 28, "Female", "202 Maple St", Department.IT, 80000, Location.CHICAGO, Arrays.asList(Project.CLOUD_MIGRATION, Project.MOBILE_APP_DEVELOPMENT)),
                new Employee("6", "Frank Miller", 32, "Male", "303 Birch St", Department.SALES, 75000, Location.BOSTON, Arrays.asList(Project.DATA_ANALYTICS)),
                new Employee("7", "Grace Lee", 29, "Female", "404 Cedar St", Department.ENGINEERING, 95000, Location.NEW_YORK, Arrays.asList(Project.CYBER_SECURITY)),
                new Employee("8", "Hank Green", 45, "Male", "505 Spruce St", Department.MARKETING, 65000, Location.SAN_FRANCISCO, Arrays.asList(Project.AI_RESEARCH)),
                new Employee("9", "Ivy White", 38, "Female", "606 Willow St", Department.HR, 72000, Location.LOS_ANGELES, Arrays.asList(Project.DEVOPS_AUTOMATION)),
                new Employee("10", "Jack Black", 27, "Male", "707 Ash St", Department.IT, 85000, Location.CHICAGO, Arrays.asList(Project.CLOUD_MIGRATION)),
                new Employee("11", "Karen Brown", 33, "Female", "808 Poplar St", Department.SALES, 78000, Location.BOSTON, Arrays.asList(Project.DATA_ANALYTICS)),
                new Employee("12", "Leo King", 31, "Male", "909 Fir St", Department.ENGINEERING, 98000, Location.NEW_YORK, Arrays.asList(Project.MOBILE_APP_DEVELOPMENT)),
                new Employee("13", "Mia Scott", 26, "Female", "1010 Pine St", Department.MARKETING, 62000, Location.SAN_FRANCISCO, Arrays.asList(Project.CYBER_SECURITY)),
                new Employee("14", "Nina Adams", 39, "Female", "1111 Maple St", Department.HR, 73000, Location.LOS_ANGELES, Arrays.asList(Project.AI_RESEARCH)),
                new Employee("15", "Oscar Clark", 34, "Male", "1212 Birch St", Department.IT, 87000, Location.CHICAGO, Arrays.asList(Project.DEVOPS_AUTOMATION)),
                new Employee("16", "Paul Walker", 36, "Male", "1313 Cedar St", Department.SALES, 79000, Location.BOSTON, Arrays.asList(Project.CLOUD_MIGRATION)),
                new Employee("17", "Quinn Harris", 29, "Female", "1414 Spruce St", Department.ENGINEERING, 92000, Location.NEW_YORK, Arrays.asList(Project.DATA_ANALYTICS)),
                new Employee("18", "Rachel Evans", 41, "Female", "1515 Willow St", Department.MARKETING, 67000, Location.SAN_FRANCISCO, Arrays.asList(Project.MOBILE_APP_DEVELOPMENT)),
                new Employee("19", "Steve Young", 37, "Male", "1616 Ash St", Department.HR, 74000, Location.LOS_ANGELES, Arrays.asList(Project.CYBER_SECURITY)),
                new Employee("20", "Tina Turner", 30, "Female", "1717 Poplar St", Department.IT, 89000, Location.CHICAGO, Arrays.asList(Project.AI_RESEARCH))
        );


        EmployeeService employeeService = new EmployeeServiceImpl();

        System.out.println("Filtered by age > 30: " + employeeService.filterByAge(employees, 30));
        System.out.println("Names: " + employeeService.getNames(employees));
        System.out.println("First employee in New York: " + employeeService.findFirstByLocation(employees, Location.NEW_YORK));

        System.out.println("Sorted by name: " + employeeService.sortByName(employees));
        System.out.println("Sum of salaries: " + employeeService.sumOfSalaries(employees));

        System.out.println("Filtered by department (Engineering): " + employeeService.filterByDepartment(employees, Department.ENGINEERING));
        System.out.println("Filtered by project (Cloud Migration): " + employeeService.filterByProject(employees, Project.CLOUD_MIGRATION));
        System.out.println("Average salary by department (Engineering): " + employeeService.averageSalaryByDepartment(employees, Department.ENGINEERING));
        System.out.println("Count by location (New York): " + employeeService.countByLocation(employees, Location.NEW_YORK));
        System.out.println("Distinct by location: " + employeeService.distinctByLocation(employees));
        System.out.println("Group by department: " + employeeService.groupByDepartment(employees));
        System.out.println("Partition by salary > 80000: " + employeeService.partitionBySalary(employees, 80000));
        System.out.println("Employee with max salary: " + employeeService.findMaxSalary(employees));
        System.out.println("Employee with min salary: " + employeeService.findMinSalary(employees));
        System.out.println("Collect to map: " + employeeService.collectToMap(employees));

    }
}