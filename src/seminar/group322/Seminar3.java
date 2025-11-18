package seminar.group322;

import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.Employer;
import seminar.group322.seminar2.domain.RepositoryException;
import seminar.group322.seminar2.repository.BinaryFileRepository;
import seminar.group322.seminar2.repository.EmployeeTextFileRepository;
import seminar.group322.seminar2.repository.Repository;
import seminar.group322.seminar2.service.EmployeeService;
import seminar.group322.seminar2.ui.ConsoleUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Seminar3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, RepositoryException {
        /*
        Lucrul cu fisiere in Java
            1. Fisiere text (clase *Reader/*Writer)
            2. Fisiere binare (clase *InputStream/*OutputStream)
            3. Serializarea obiectelor (interfata Serializable, clasele ObjectOutputStream/ObjectInputStream)
         */


        Employee e1 = new Employee(1000, "Popescu Marcel", 12345);
        Employee e2 = new Employee(1001, "Marian Ana", 33456);
        Employee e3 = new Employee(1002, "Marcel Marius", 12000);
        Employer boss = new Employer(2000, "Pop Dan");
        boss.addEmployee(e1);
        boss.addEmployee(e2);


        // e1 is our lucky employee ! -> they get to be persisted in a file
//        List<Employee> employees = new ArrayList<>();
//        employees.add(e1);
//        employees.add(e2);
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.bin"));
//        oos.writeObject(employees);
//        oos.close();
        //

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.bin"));
//        ArrayList employee = (ArrayList) ois.readObject();
//        ois.close();
//
//        System.out.println(employee);


        Repository<Employee> repoBinary = new BinaryFileRepository<>("employees.bin");
//        System.out.println(repoBinary.toString());

//        Repository<Employee> repoText = new EmployeeTextFileRepository("employees.txt");
        repoBinary.add(e1);
        repoBinary.add(e2);
        repoBinary.add(e3);

//        System.out.println(repoText);
//        for (Employee e : repoText) {
//            System.out.println(e);
//        }


//        try {
//            repository.add(e1);
//            repository.add(e2);
//        } catch (RepositoryException exc) {
//            System.out.println(exc.getMessage());
//        }


//        EmployeeService employeeService = new EmployeeService(repository);
//        ConsoleUI ui = new ConsoleUI(employeeService);
//        ui.start();
    }
}
