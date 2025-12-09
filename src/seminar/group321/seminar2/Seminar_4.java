package seminar.group321.seminar2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Seminar_4 {
    public static void main(String[] args) throws Exception {


//        Repository<Author> authorRepo = new AuthorTextFileRepository("authors.txt");
//        authorRepo.add(new Author(1001, "Mihai Eminescu"));
//        authorRepo.add(new Author(1002, "Ion Creanga"));
//        authorRepo.add(new Author(1003, "Ioan Slavici"));

//        for (var a : authorRepo) {
//            System.out.println(a);
//        }

        // Properties in Java este de fapt un dictionar de perechi chei <-> valoare
//        Properties settings = new Properties();
////        settings.put("repo-type", "binary_repository");
////        settings.put("repo-file", "authors.bin");
////        settings.store(new FileWriter("my_settings.properties"), "This is a comment");
//
//        settings.load(new FileReader("my_settings.properties"));
//        System.out.println(settings.getProperty("repo-type"));



        /*
        Ce ar mai trebui implementat ca sa avem o aplicatie ca aplicatiile Java aflate in productie?
        -> putem internationaliza aplicatia -> pentru fiecare limba, creati un fisier .properties cu toate
        string-urile in acea limba. Sirurile de caractere afisate in program sunt incarcate din acel fisier
        properties
        
        -> Eliminam if-urile din Settings. Asta ne permite sa implementam repository-uri noi fara ca sa modificam
        codul sursa. Aici se foloseste Java Reflection => dam numele clasei incarcate ca si un String.

        -> Eliminam utilizarea de SQL din aplicatie. Folosim un tool de genul Hibernate, care stie mapa automat
        clasele Java in tabele ale bazei de date.
         */
        try (Repository<Author> repository = Settings.getInstance().getRepository()) {
            for (var author : repository) {
                System.out.println(author);
            }
        }
    }
}
