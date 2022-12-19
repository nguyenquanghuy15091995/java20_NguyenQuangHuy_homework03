package java20.nqh.homework3.controllers;

import java20.nqh.homework3.models.*;

import java.util.Scanner;

public class CompanyController {
    private Company company;

    private Scanner scanner;

    public CompanyController() {
        this.company = new Company();
        this.scanner = new Scanner(System.in);
        this.scanner.useDelimiter("\n");
    }

    public void setCompanyInfo() {
        System.out.println("---Enter Company information");
        System.out.print("- Company name: ");
        this.company.setName(this.scanner.next());
        System.out.print("- Company Tax Code: ");
        this.company.setTaxCode(this.scanner.next());
    }

    public void showAllEmployee() {
        System.out.println("---Show all employee information");
        for (Person person :
                this.company.getPersonList()) {
            if (!person.isDeleted()) {
                if (person instanceof Employee) {
                    System.out.println(person.getCode() + " - " + person.getName() + " - " + person.getPhoneNumber() + " - Manager: " + ((Employee) person).getManagerCode());
                } else {
                    System.out.println(person.getCode() + " - " + person.getName() + " - " + person.getPhoneNumber());
                }
            }
        }
    }

    public void addNewEmployee() {
        System.out.println("- Select employee type: ");
        System.out.println("1. Director");
        System.out.println("2. Manager");
        System.out.println("3. Employee");
        System.out.print("Your choice: ");
        int selectedType = this.scanner.nextInt();

        System.out.print("Employee code: ");
        String newCode = this.scanner.next();
        System.out.print("Employee name: ");
        String newName = this.scanner.next();
        System.out.print("Employee phone number: ");
        String newPhone = this.scanner.next();

        Person newPerson = null;
        switch (selectedType) {
            case 1: {
                System.out.print("Stock: ");
                double newStock = this.scanner.nextDouble();
                newPerson = new Director(newCode, newName, newPhone, newStock);
                break;
            }
            case 2: {
                newPerson = new Manager(newCode, newName, newPhone);
                break;
            }
            case 3: {
                newPerson = new Employee(newCode, newName, newPhone);
                break;
            }
            default:
        }

        if (!newPerson.equals(null)) {
            this.company.addNewPeron(newPerson);
        }
    }

    public void deleteEmployee() {
        System.out.print("- Select employee code to deleted: ");
        String code = this.scanner.next();
        this.company.deletePerson(code);
    }

    public void setManagerForEmployee() {
        System.out.print("- Enter manager code: ");
        String managerCode = this.scanner.next();
        System.out.print("- Enter employee code: ");
        String employeeCode = this.scanner.next();

        this.company.setManagerForEmployee(managerCode, employeeCode);
    }

    public void addRevenueToPerson() {
        System.out.print("- Enter person code: ");
        String personCode = this.scanner.next();
        System.out.print("- Enter Month: ");
        byte month = this.scanner.nextByte();
        System.out.print("- Enter Year: ");
        int year = this.scanner.nextInt();
        System.out.print("- Enter Working day: ");
        double workingDay = this.scanner.nextDouble();

        this.company.addSalaryToPerson(personCode, month, year, workingDay);
    }

    public void showTotalRevenue() {
        System.out.print("- Enter Month: ");
        byte month = this.scanner.nextByte();
        System.out.print("- Enter Year: ");
        int year = this.scanner.nextInt();
        double totalRevenue = this.company.showTotalRevenue(month, year);
        System.out.println("Total revenue of company: " + totalRevenue);
    }

    public void showManagerWithLargestEmpNumber() {
        Manager manager = this.company.getManagerWithLargestEmpNumber();
        if (manager == null) {
            System.out.println("No result");
        } else {
            System.out.println("- The manager with largest employee number is: " + manager);
        }
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
        System.out.println("13. Add revenue to employee");
        System.out.println("------------------------------------------------");
        System.out.println("Input -1 for exit");
        System.out.println("------------------------------------------------");
        System.out.println("-----------------");
        System.out.print("Select your choice: ");
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
            } else if (selection == 3) {
                this.addNewEmployee();
            } else if (selection == 4) {
                this.deleteEmployee();
            } else if (selection == 5) {
                this.showAllEmployee();
            } else if (selection == 6) {
                this.showTotalRevenue();
            } else if (selection == 7) {
                this.showManagerWithLargestEmpNumber();
            } else if (selection == 13) {
                this.addRevenueToPerson();
            }
        }
    }
}
