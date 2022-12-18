package java20.nqh.homework3.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private List<Revenue> revenues;
    private List<Person> personList;


    public Company() {
        this.name = "";
        this.taxCode = "";
        this.revenues = new ArrayList<Revenue>();
        this.personList = new ArrayList<Person>();
    }

    public void syncRevenueWithDepartment() {

    }

    public void setManagerForEmployee(int managerId, int employeeId) {

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

    public void setRevenues(List<Revenue> revenues) {
        this.revenues = revenues;
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
}
