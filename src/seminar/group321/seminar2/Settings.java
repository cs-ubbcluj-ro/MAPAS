package seminar.group321.seminar2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Fisierul de setari se citeste o singura data, la pornirea programului => va exista un singur obiect de
 * tip Settings => putem implementa sablonul de proiectare (eng. design pattern) Singleton
 */

// Obiectul acestei clase mentine obiectul repository folosit de program
public class Settings {
    // campurile sunt private pentru ca sunt accesate prin getteri
    // repository poate (si trebuie) sa fie inlocuit de orice subclasa
    private Repository<Author> repository;

    // Constructorul poate fi apelat doar din interiorul clasei Settings => va fi apelat din interiorul
    // unei metode statice
    private Settings(Repository<Author> repository) {
        this.repository = repository;
    }

    public Repository<Author> getRepository() {
        return repository;
    }

    // Atributul static de mai jos retine obiectul care este returnat de getInstance()
    private static Settings instance;

    // Metoda getInstance() poate fi apelata de oriunde, fiind publica
    // Metoda e si statica => nu trebuie sa creez un obiect de tipul Settings
    // Numele "getInstance()" e folosit de regula in sablonul Singleton
    public static Settings getInstance() {
        if (instance == null) {
            // aici cream obiectul Singleton -- blocul de cod din if se ruleaza exact o data pe durata
            // executiei programului

            Properties settings = new Properties();
            // try-with-resources se asigura ca fisierul citit va fi inchis
            try (var fr = new FileReader("my_settings.properties")) {
                settings.load(fr);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // initializam setarile
            // momentan nu cunoastem o metoda mai buna decat utilizarea de if-uri :(
            var repo_type = settings.getProperty("repo-type");
            var repo_file = settings.getProperty("repo-file");
            Repository<Author> repo = null;


            if ("memory-repo".equals(repo_type)) {
                repo = new Repository<>();
            } else if ("text_repository".equals(repo_type)) {
                repo = new AuthorTextFileRepository(repo_file);
            } else if ("binary_repository".equals(repo_type)) {
                repo = new BinaryFileRepository<>(repo_file);
            } else if ("sql_repository".equals(repo_type)) {
                repo = new SQLAuthorRepository();
            } else {
                throw new RuntimeException("Incorrect repository type - " + repo_type);
            }

            // Aici cream obiectul singleton
            instance = new Settings(repo);
        }
        return instance;
    }
}
