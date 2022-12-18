package java20.nqh.homework3.controllers;

import java20.nqh.homework3.fakedata.FakeData;
import java20.nqh.homework3.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompanyController {
    private Company company;

    private Scanner scanner;

    public CompanyController() {
        this.company = new Company();
        this.scanner = new Scanner(System.in);
    }

    public void setCompanyInfo() {
        System.out.println("---Enter Company information");
        System.out.print("- Company name: ");
        this.company.setName(this.scanner.next());
        System.out.print("- Company Tax Code: ");
        this.company.setTaxCode(this.scanner.next());

        FakeData fakeData = new FakeData();
        this.company.setDepartments(new ArrayList<Department>(
                Arrays.asList(
                        fakeData.department1,
                        fakeData.department2,
                        fakeData.department3
                )
        ));
        this.company.setDirectors(new ArrayList<Director>(
                Arrays.asList(
                        fakeData.director1,
                        fakeData.director2
                )
        ));
    }

    public void setManagerForEmployee() {
        System.out.println("---Set manager for employee");
        System.out.println("- Select employee");
        for (Department department :
                this.company.getDepartments()) {
            for (Employee employee :
                    department.getEmployees()) {
                System.out.println(employee.getId() + " - " + employee.getName());
            }
        }
        System.out.println("- Employee id: ");
        int employeeId = this.scanner.nextInt();
        System.out.println("- Select manager");
        for (Department department :
                this.company.getDepartments()) {
            System.out.println(department.getManager().getId() + " - " + department.getManager().getName());
        }
        int managerId = this.scanner.nextInt();
        this.company.setManagerForEmployee(managerId, employeeId);
    }

    private List<Person> getPersonList() {
        List<Person> personsTemp = new ArrayList<Person>();
        for (Director director :
                this.company.getDirectors()) {
            personsTemp.add(director);
        }

        for (Department department :
                this.company.getDepartments()) {
            personsTemp.add(department.getManager());
            for (Employee employee :
                    department.getEmployees()) {
                personsTemp.add(employee);
            }
        }
        return personsTemp;
    }

    public void showAllEmployee() {
        System.out.println("--- Show all Employee");
        List<Person> personsTemp = this.getPersonList();
        int counter = 1;
        for (Person person:
                personsTemp) {
            System.out.println(counter + ". " + person.getName() + " - " + person.getCode() + " - " + person.getPhoneNumber());
            counter += 1;
        }
    }

    public void deleteEmployee() {
        System.out.println("--- Delete Employee");
        System.out.println("Input employee id: ");

    }

    public void showMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("Menu");
        System.out.println("1. Input company information");
        System.out.println("2. Set manager for employee");
        System.out.println("3. Add new employee");
        System.out.println("4. Delete a employee");
        System.out.println("5. Show all employee information");
        System.out.println("6. Show total revenue of company");
        System.out.println("7. Get employee who has highest revenue");
        System.out.println("8. Get manager who has greatest quantity of employee");
        System.out.println("9. Sort employee as abc");
        System.out.println("10. Sort employee as desc of revenue");
        System.out.println("11. Get Director with highest stock");
        System.out.println("12. Get Director revenue");
        System.out.println("------------------------------------------------");
        System.out.println("Input -1 for exit");
        System.out.println("------------------------------------------------");
    }

    public void runAll() {
        int selection = 0;
        while (selection != -1) {
            this.showMenu();
            selection = this.scanner.nextInt();
            if (selection == 1) {
                this.setCompanyInfo();
            } else if (selection == 2) {
                this.setManagerForEmployee();
            } else if (selection == 5) {
                this.showAllEmployee();
            }
        }
    }
}
