package seminar.group322.seminar2.ui;

import seminar.group322.seminar2.service.EmployeeService;

import java.util.Scanner;

public class ConsoleUI {

    private EmployeeService employeeService;

    public ConsoleUI(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private void printMenu() {
        System.out.println("1. Display all employees");
        System.out.println("2. Add employee");
        System.out.println("0. Exit");
    }

    private void displayAllEmployees() {
        System.out.println(employeeService);
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        boolean keepRunning = true;
        do {
            printMenu();

            // TODO De modificat in String, astfel incat sa nu am exceptie la input
            int option = in.nextInt();
            switch (option) {
                case 1:
                    // Implementez o metoda ca sa nu aglomerez bucla principala a UI
                    displayAllEmployees();
                    break;
                case 2:
                    // TODO De implementat citirea datelor unui Employee + adaugarea in Service
                    break;
                case 0:
                    keepRunning = false;
                    break;
            }
        } while (keepRunning);
        System.out.println("Bye!");
    }
}
