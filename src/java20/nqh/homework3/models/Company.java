package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private List<Person> personList;


    public Company() {
        this.name = "";
        this.taxCode = "";
        this.personList = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addNewPeron(Person newPerson) {
        boolean isAvailable = true;
        for (Person person :
                this.personList) {
            if (person.getCode().equals(newPerson.getCode())) {
                isAvailable = false;
                break;
            }
        }
        if (isAvailable) {
            this.personList.add(newPerson);
        }
    }

    public void deletePerson(String employeeCode) {
        boolean isManager = false;
        for (int i = 0; i < this.personList.size(); i += 1) {
            if (this.personList.get(i).getCode().equals(employeeCode)) {
                this.personList.get(i).setDeleted(true);
                if (this.personList.get(i) instanceof Manager) {
                    isManager = true;
                }
                break;
            }
        }
        if (isManager) {
            for (int i = 0; i < this.personList.size(); i += 1) {
                if (this.personList.get(i) instanceof Employee && ((Employee) this.personList.get(i)).getManagerCode().equals(employeeCode)) {
                    ((Employee) this.personList.get(i)).setManagerCode("null");
                }
            }
        }
    }

    public void setManagerForEmployee(String managerCode, String employeeCode) {
        Manager managerTemp = null;
        for (int i = 0; i < this.personList.size(); i += 1) {
            if (this.personList.get(i) instanceof Manager && this.personList.get(i).getCode().equals(managerCode) && !this.personList.get(i).isDeleted()) {
                ((Manager) this.personList.get(i)).plusEmployeeNumber(1);
                managerTemp = ((Manager) this.personList.get(i));
                break;
            }
        }

        if (managerTemp != null) {
            for (int i = 0; i < this.personList.size(); i += 1) {
                if (this.personList.get(i) instanceof Employee && this.personList.get(i).getCode().equals(employeeCode) && !this.personList.get(i).isDeleted()) {
                    ((Employee) this.personList.get(i)).setManagerCode(managerTemp.getCode());
                    break;
                }
            }
        }
    }

    public void addSalaryToPerson(String personCode, byte month, int year, double workingDay) {
        for (int i = 0; i < this.personList.size(); i += 1) {
            if (this.personList.get(i).getCode().equals(personCode) && !this.personList.get(i).isDeleted()) {
                this.personList.get(i).addSalary(month, year, workingDay);
                break;
            }
        }
    }

    public double showTotalRevenue(byte month, int year) {
        double revenueValue = 0;
        for (Person person:
             this.personList) {
            if(person.getSalaryByMonth(month, year) != null) {
                revenueValue += person.getSalaryByMonth(month, year).getCalculatedSalary();
            }
        }
        return revenueValue;
    }

    public Manager getManagerWithLargestEmpNumber() {
        Manager managerTemp = null;
        for (Person person:
                this.personList) {
            if(person instanceof Manager) {
                if (managerTemp == null) {
                    managerTemp = (Manager) person;
                } else {
                    if (managerTemp.getEmployeeNumber() < ((Manager) person).getEmployeeNumber()) {
                        managerTemp = (Manager) person;
                    }
                }
            }
        }
        return managerTemp;
    }
}
