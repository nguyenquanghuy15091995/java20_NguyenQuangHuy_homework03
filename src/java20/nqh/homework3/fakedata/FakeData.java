package java20.nqh.homework3.fakedata;

import java20.nqh.homework3.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeData {
    public final double SALARY_PER_DAY_EMPLOYEE = 100;
    public final double SALARY_PER_DAY_MANAGER = 200;
    public final double SALARY_PER_DAY_DIRECTOR = 300;

    public final Person manager1 = new Manager(1, "manager_1", "Manager 1", "0123456789");
    public final Person manager2 = new Manager(2, "manager_2", "Manager 2", "0123456789");
    public final Person manager3 = new Manager(3, "manager_3", "Manager 3", "0123456789");

    public final List<Employee> employees1 = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(4, "employee_1", "Employee 1", "0123456789"),
                    new Employee(5, "employee_2", "Employee 2", "0123456789"),
                    new Employee(6, "employee_3", "Employee 3", "0123456789")
            )
    );

    public final List<Employee> employees2 = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(7, "employee_4", "Employee 4", "0123456789"),
                    new Employee(8, "employee_5", "Employee 5", "0123456789"),
                    new Employee(9, "employee_6", "Employee 6", "0123456789"),
                    new Employee(10, "employee_7", "Employee 7", "0123456789")
            )
    );
    public final List<Employee> employees3 = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(11, "employee_8", "Employee 8", "0123456789"),
                    new Employee(12, "employee_9", "Employee 9", "0123456789"),
                    new Employee(13, "employee_10", "Employee 10", "0123456789"),
                    new Employee(14, "employee_11", "Employee 11", "0123456789"),
                    new Employee(15, "employee_12", "Employee 12", "0123456789")
            )
    );
    public final Department department1 = new Department(
            "Department 1",
            (Manager) this.manager1,
            employees1
    );

    public final Department department2 = new Department(
            "Department 2",
            (Manager) this.manager2,
            employees2
    );

    public final Department department3 = new Department(
            "Department 3",
            (Manager) this.manager3,
            employees3
    );

    public final Director director1 = new Director(16, "director_1", "Director 1", "0123456789", 40);
    public final Director director2 = new Director(16, "director_2", "Director 2", "0123456789", 60);
}
