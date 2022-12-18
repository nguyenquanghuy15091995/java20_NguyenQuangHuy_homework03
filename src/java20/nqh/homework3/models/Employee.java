package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {
    private String managerCode;

    public Employee(String code, String name, String phoneNumber, List<Revenue> salaries) {
        super(code, name, phoneNumber, salaries);
    }

    public Employee(String code, String name, String phoneNumber) {
        super(code, name, phoneNumber, new ArrayList<Revenue>());
    }

    @Override
    protected void addSalary(byte month, int year, double salaryPerDay, double workingDay) {
        double calculatedSalary = salaryPerDay * workingDay;
        Revenue newSalary = new Revenue(month,  year,  salaryPerDay,  workingDay, calculatedSalary);
        this.salaries.add(newSalary);
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }
}
