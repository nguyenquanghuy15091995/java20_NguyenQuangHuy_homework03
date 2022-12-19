package java20.nqh.homework3.models;

import java.util.List;

public abstract class Person {
    protected String code;
    protected String name;
    protected String phoneNumber;
    protected List<Revenue> salaries;

    protected boolean isDeleted;

    public Person(String code, String name, String phoneNumber, List<Revenue> salaries) {
        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salaries = salaries;
        this.isDeleted = false;
    }

    protected abstract void addSalary(byte month, int year, double workingDay);

    public Revenue getSalaryByMonth(byte month, int year) {
        for (Revenue revenueTemp:
             this.salaries) {
            if (revenueTemp.getMonth() == month && revenueTemp.getYear() == year) {
                return revenueTemp;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Revenue> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Revenue> salaries) {
        this.salaries = salaries;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
