package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private List<Revenue> revenues;
    private List<Department> departments;

    private List<Director> directors;

    public Company(String name, String taxCode, List<Department> departments, List<Director> directors) {
        this.name = name;
        this.taxCode = taxCode;
        this.departments = departments;
        this.revenues = new ArrayList<Revenue>();
        this.directors = directors;
        this.syncRevenueWithDepartment();
    }

    public Company() {
        this.name = "";
        this.taxCode = "";
        this.departments = new ArrayList<Department>();
        this.revenues = new ArrayList<Revenue>();
        this.directors = new ArrayList<Director>();
    }

    public void syncRevenueWithDepartment() {
        for (Department departmentTemp :
                this.departments) {
            for (Revenue salaryTemp :
                    departmentTemp.getManager().getSalaries()) {
                for (int i = 0; i < this.revenues.size(); i += 1) {
                    if (salaryTemp.getMonth() == this.revenues.get(i).getMonth() && salaryTemp.getYear() == this.revenues.get(i).getYear()) {
                        Revenue newRevenue = new Revenue(salaryTemp.getMonth(), salaryTemp.getYear(), salaryTemp.getCalculatedSalary() + this.revenues.get(i).getCalculatedSalary());
                        this.revenues.set(i, newRevenue);
                    } else {
                        this.revenues.add(new Revenue(salaryTemp.getMonth(), salaryTemp.getYear(), salaryTemp.getCalculatedSalary()));
                    }
                }
            }
        }
    }

    public void setManagerForEmployee(int managerId, int employeeId) {
        List<Department> newDepartments = new ArrayList<Department>();
        Employee newEmployee = null;
        for (Department department:
                this.departments) {
            Department departmentTemp = department;
            for (Employee employee:
                    department.getEmployees()) {
                if(employee.getId() == employeeId) {
                    departmentTemp.removeEmployeeById(employee.getId());
                    newEmployee = employee;
                    break;
                }
            }
            newDepartments.add(departmentTemp);
        }

        for (int i = 0; i < newDepartments.size(); i += 1) {
            if(newDepartments.get(i).getManager().getId() == managerId && !newEmployee.equals(null)) {
                newDepartments.get(i).addEmployee(newEmployee);
                break;
            }
        }

        this.departments = newDepartments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public List<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenue(List<Revenue> revenues) {
        this.revenues = revenues;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
        this.syncRevenueWithDepartment();
    }
}
