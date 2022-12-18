package java20.nqh.homework3.controllers;

import java20.nqh.homework3.fakedata.FakeData;
import java20.nqh.homework3.models.Company;
import java20.nqh.homework3.models.Department;
import java20.nqh.homework3.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompanyController {
    private Company company;

    private Scanner scanner;

    public CompanyController() {
        this.company = new Company();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("Menu");
        System.out.println("1. Input company information");
        System.out.println("2. Set manager for employee");
        System.out.println("3. Add new employee");
        System.out.println("4. Delete a employee");
        System.out.println("5. Show all empoyee information");
        System.out.println("6. Show total revenue of company");
        System.out.println("7. Get employee who has highest revenue");
        System.out.println("8. Get manager who has greatest quantity of employee");
        System.out.println("9. Sort employee as abc");
        System.out.println("10. Sort employee as desc of revenue");
        System.out.println("11. Get Director with highest stock");
        System.out.println("12. Get Director revenue");
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
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
}
