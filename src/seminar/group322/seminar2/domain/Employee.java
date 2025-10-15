package seminar.group322.seminar2.domain;

public class Employee extends Person {

    private int salary;

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
