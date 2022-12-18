package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Director extends Person {
    private double stock;

    public Director(int id, String code, String name, String phoneNumber, List<Revenue> salaries, double stock) {
        super(id, code, name, phoneNumber, salaries);
        this.stock = stock;
    }

    public Director(int id, String code, String name, String phoneNumber, double stock) {
        super(id, code, name, phoneNumber, new ArrayList<Revenue>());
        this.stock = stock;
    }

    @Override
    protected void addSalary(byte month, int year, double salaryPerDay, double workingDay) {
        double calculatedSalary = salaryPerDay * workingDay;
        Revenue newSalary = new Revenue(month,  year,  salaryPerDay,  workingDay, calculatedSalary);
        this.salaries.add(newSalary);
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
