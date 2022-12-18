package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person {
    private int employeeNumber;

    public Manager(int id, String code, String name, String phoneNumber, List<Revenue> salaries, int employeeNumber) {
        super(id, code, name, phoneNumber, salaries);
        this.employeeNumber = employeeNumber;
    }

    public Manager(int id, String code, String name, String phoneNumber) {
        super(id, code, name, phoneNumber, new ArrayList<Revenue>());
        this.employeeNumber = 0;
    }

    @Override
    protected void addSalary(byte month, int year, double salaryPerDay, double workingDay) {
        double calculatedSalary = salaryPerDay * workingDay + 100 * this.employeeNumber;
        Revenue newSalary = new Revenue(month,  year,  salaryPerDay,  workingDay, calculatedSalary);
        this.salaries.add(newSalary);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
