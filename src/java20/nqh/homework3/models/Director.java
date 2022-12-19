package java20.nqh.homework3.models;

import java20.nqh.homework3.common.Common;

import java.util.ArrayList;
import java.util.List;

public class Director extends Person {
    private double stock;

    public Director(String code, String name, String phoneNumber, List<Revenue> salaries, double stock) {
        super(code, name, phoneNumber, salaries);
        this.stock = stock;
    }

    public Director(String code, String name, String phoneNumber, double stock) {
        super(code, name, phoneNumber, new ArrayList<Revenue>());
        this.stock = stock;
    }

    @Override
    protected void addSalary(byte month, int year, double workingDay) {
        double calculatedSalary = Common.SALARY_PER_DAY_DIRECTOR * workingDay;
        Revenue newSalary = new Revenue(month,  year,  Common.SALARY_PER_DAY_DIRECTOR,  workingDay, calculatedSalary);
        this.salaries.add(newSalary);
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
