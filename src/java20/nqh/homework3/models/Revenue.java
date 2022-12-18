package java20.nqh.homework3.models;

public class Revenue {
    private byte month;
    private int  year;
    private double salaryPerDay;
    private double workingDay;
    private double calculatedSalary;

    public Revenue(byte month, int year, double salaryPerDay, double workingDay) {
        this.month = month;
        this.year = year;
        this.salaryPerDay = salaryPerDay;
        this.workingDay = workingDay;
    }

    public Revenue(byte month, int year, double salaryPerDay, double workingDay, double calculatedSalary) {
        this.month = month;
        this.year = year;
        this.salaryPerDay = salaryPerDay;
        this.workingDay = workingDay;
        this.calculatedSalary = calculatedSalary;
    }

    public Revenue(byte month, int year, double calculatedSalary) {
        this.month = month;
        this.year = year;
        this.calculatedSalary = calculatedSalary;
    }

    public double getCalculatedSalary() {
        return calculatedSalary;
    }

    public void setCalculatedSalary(double calculatedSalary) {
        this.calculatedSalary = calculatedSalary;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public double getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(double workingDay) {
        this.workingDay = workingDay;
    }
}
