package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Manager manager;
    private List<Employee> employees;

    public Department(String name, Manager manager, List<Employee> employees) {
        this.name = name;
        this.manager = manager;
        this.employees = employees;
        this.manager.setEmployeeNumber(employees.size());
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void removeManager() {
        this.manager = null;
    }

    public void removeEmployeeById(int id) {
        List<Employee> employeesTemp = new ArrayList<Employee>();
        this.manager.setEmployeeNumber(this.employees.size() - 1);
        for (Employee employee :
                this.employees) {
            if (employee.getId() != id) {
                employeesTemp.add(new Employee(employee.getId(), employee.getCode(), employee.getName(), employee.getPhoneNumber(), employee.getSalaries()));
            }
        }
        this.setEmployees(employeesTemp);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
