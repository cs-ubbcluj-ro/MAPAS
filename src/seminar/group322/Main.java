package seminar.group322;

import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.Employer;
import seminar.group322.seminar2.domain.Person;
import seminar.group322.seminar2.repository.Repository;
import seminar.group322.seminar2.service.EmployeeService;
import seminar.group322.seminar2.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {


        Employee e1 = new Employee(1000, "Popescu Marcel", 12345);
        Employee e2 = new Employee(1001, "Marian Ana", 33456);
        Employer boss = new Employer(2000, "Pop Dan");
        boss.addEmployee(e1);
        boss.addEmployee(e2);


        Repository repository = new Repository();
        repository.addPerson(e1);
        repository.addPerson(e2);
//        repository.addPerson(boss);
//        System.out.println(repository);

        // Exemplu pentru metode virtuale/non-virtuale (Java vs. C++)
//        Person p = e1;
//        if (Math.random() < 0.5) {
//            p = boss;
//        }
//        System.out.println(p.toString());


//        System.out.println(boss);

        EmployeeService employeeService = new EmployeeService(repository);
        ConsoleUI ui = new ConsoleUI(employeeService);
        ui.start();
    }
}
