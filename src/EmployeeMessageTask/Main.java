package EmployeeMessageTask;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // EmployeeTask
        List<Employee> employees = Employee.employeeGenerator(30);
        System.out.println(employees);
        employees.sort(new EmployeeNameComparator());
        System.out.println(employees);
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()));
        System.out.println(employees);
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()).
                thenComparing(new EmployeeAgeComparator()).thenComparing(new EmployeeCompanyComparator()));
        System.out.println(employees);
    }
}
