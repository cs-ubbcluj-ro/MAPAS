package seminar.group322.seminar2.domain;


import java.util.ArrayList;

public class Employer extends Person {
    // employeeList se initializeaza in constructor
    private final ArrayList<Employee> employeeList = new ArrayList<>();

    public Employer(int id, String name) {
        super(id, name);
    }

    public void addEmployee(Employee e) {
        this.employeeList.add(e);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employeeList=" + employeeList +
                "} " + super.toString();
    }
}
