package seminar.group322.seminar2.domain;

import java.io.Serializable;

public class Employee extends Person {

    // transient - atributul nu se salveaza in cadrul procesului de serializare
    private transient int salary;

    public Employee() {
    }

    public Employee(int id, String name, int salary) {
        super(id, name);
        if (salary < 10000) {
            throw new IllegalArgumentException("Salary too low");
        }
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString();
    }

}
