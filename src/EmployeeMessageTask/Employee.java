package EmployeeMessageTask;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

public class Employee implements Comparable<Employee>{
    private String name;
    private String company;
    private int salary;
    private int age;

    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company != null && !"".equals(company)) {
            this.company = company;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 60 && age >= 21) {
            this.age = age;
        }
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int)(Math.random()*names.length)],
                    companies[(int)(Math.random()*companies.length)], (int)(Math.random()*3000 + 2000),
                    (int)(Math.random()*40 + 21)));
        }
        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getSalary() == employee.getSalary() &&
                getAge() == employee.getAge() &&
                getName().equals(employee.getName()) &&
                getCompany().equals(employee.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCompany(), getSalary(), getAge());
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.hashCode(), o.hashCode());
    }
}
class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class EmployeeCompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}


