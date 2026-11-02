package lecture.livecoding;

import lecture.livecoding.domain.Square;
import lecture.livecoding.domain.SquareConverter;
import lecture.livecoding.domain.UnitSquare;
import lecture.livecoding.repository.IRepository;
import lecture.livecoding.repository.RepositoryException;
import lecture.livecoding.repository.TextFileRepository;
import lecture.livecoding.util.Settings;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Lecture6 {
    public static void main(String[] args) throws RepositoryException, IOException {

        IRepository<Square> repo = new TextFileRepository<>("squares.txt", new SquareConverter());
//        repo.store(UnitSquare.getInstance());
//        repo.store(new Square(1002, "one big square", 99));


        for (var elem : repo) {
            System.out.println(elem);
        }

//        Properties settings = new Properties();
//        settings.load(new FileReader("settings.properties"));
//
//        System.out.println(settings.getProperty("repository_type"));
//        System.out.println(settings.getProperty("repository_file"));

//        var repository = Settings.getInstance().getRepository();
//
//        System.out.println(repository.getClass());
//
//        System.out.println("All shapes in repository:");
//        for (var shape : repository) {
//            System.out.println(shape);
//        }
    }
}
