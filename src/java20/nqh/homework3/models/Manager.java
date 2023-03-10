package java20.nqh.homework3.models;

import java20.nqh.homework3.common.Common;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person {
    private int employeeNumber;

    public Manager(String code, String name, String phoneNumber, List<Revenue> salaries, int employeeNumber) {
        super(code, name, phoneNumber, salaries);
        this.employeeNumber = employeeNumber;
    }

    public Manager(String code, String name, String phoneNumber) {
        super(code, name, phoneNumber, new ArrayList<Revenue>());
        this.employeeNumber = 0;
    }

    @Override
    protected void addSalary(byte month, int year, double workingDay) {
        double calculatedSalary = Common.SALARY_PER_DAY_MANAGER * workingDay + 100 * this.employeeNumber;
        Revenue newSalary = new Revenue(month,  year,  Common.SALARY_PER_DAY_MANAGER,  workingDay, calculatedSalary);
        this.salaries.add(newSalary);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void plusEmployeeNumber(int empNum) {
        this.employeeNumber += empNum;
    }

    public void minusEmployeeNumber(int empNum) {
        this.employeeNumber -= empNum;
    }
}
