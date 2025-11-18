package seminar.group322;

import seminar.group322.seminar2.Settings;
import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.domain.RepositoryException;
import seminar.group322.seminar2.repository.Repository;
import seminar.group322.seminar2.repository.SQLEmployeeRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Seminar4 {
    public static void main(String[] args) throws Exception {
//        Properties settings = new Properties();
//        settings.setProperty("repo_type", "text_file");
//        settings.setProperty("repo_file", "employees.txt");
//
//        settings.store(new FileWriter("settings.properties"), "no comment");

//        settings.load(new FileReader("settings.properties"));
//        System.out.println(settings.getProperty("repo_type"));
//        System.out.println(settings.getProperty("repo_file"));

        Settings programSettings = Settings.getInstance();
        Repository<Employee> repo = programSettings.getRepository();
        for (var e : repo) {
            System.out.println(e);
        }

        // Folosim try-with-resources, care garanteaza ca legatura cu baza de date
        // este inchisa indiferent de ce erori pot sa apara
//        try (SQLEmployeeRepository sqlRepo = new SQLEmployeeRepository()) {
//            for (var e : repo) {
//                sqlRepo.add(e);
//            }
            // try (...) garanteaza ca conexiunea cu BD se inchide, indiferent ce
            // eroare apare
        }
    }

