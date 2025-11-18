package seminar.group322.seminar2;

import seminar.group322.seminar2.domain.Employee;
import seminar.group322.seminar2.repository.BinaryFileRepository;
import seminar.group322.seminar2.repository.EmployeeTextFileRepository;
import seminar.group322.seminar2.repository.Repository;
import seminar.group322.seminar2.repository.SQLEmployeeRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Clasa implementeaza sablonul de proiectare Singleton
 */
public class Settings {
    private final Repository<Employee> repository;

    // constructorul e private ca sa ne asiguram ca noi controlam crearea
    // obiectului (de ex, fisierul de prop e citit exact o data)
    private Settings(Repository<Employee> repository) {
        this.repository = repository;
    }

    public Repository<Employee> getRepository() {
        return repository;
    }

    // singurul obiect de tip Settings e pastrat in aceasta variabila statica
    private static Settings instance;

    // Folosim Settings.getInstance() pentru a obtine instanta
    // Este un exemplu de "lazy-loading" - fisierul de properietati se citeste
    // doar cand este nevoie de el
    public static Settings getInstance() {
        // verificam daca nu cumva am creat deja un obiect Settings
        if (instance == null) {
            Properties settings = new Properties();
            try {
                settings.load(new FileReader("settings.properties"));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }

            Repository<Employee> repository;

            /**
             * FIXME de inlocuit numele explicite de clase :(
             *
             * Faptul ca in fisier sunt referite nume de clase care implementeaza
             * Repository creeaza o dependenta fata de aceste clase
             *
             * ?
             *
             * Daca vrem o implementare noua de Repository (ex. SQLEmployeeRepository)
             * va trebui sa modificam codul de mai jos :(
             *
             * Dependenta asta se elimina folosind Java reflection
             */
            if ("text_file".equals(settings.getProperty("repo_type"))) {
                repository = new EmployeeTextFileRepository(settings.getProperty("repo_file"));
            } else if ("binary_file".equals(settings.getProperty("repo_type"))) {
                repository = new BinaryFileRepository<>(settings.getProperty("repo_file"));
            } else if ("sql".equals(settings.getProperty("repo_type"))) {
                repository = new SQLEmployeeRepository();
            } else {
                throw new IllegalArgumentException("Invalid settings file");
            }
            // Linia de mai jos se executa o singura data
            instance = new Settings(repository);
        }
        return instance;
    }
}
