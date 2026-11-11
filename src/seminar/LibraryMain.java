package seminar;

import seminar.domain.Author;
import seminar.domain.Book;
import seminar.repository.AuthorTextFileRepository;
import seminar.repository.LibraryObjectRepository;
import seminar.repository.RepositoryException;
import seminar.repository.TextFileBookRepository;

public class LibraryMain {
    public static void main(String[] args) throws RepositoryException {

        var a1 = new Author(200, "Ion Creangă");
        var a2 = new Author(201, "Ioan Slavici");
        var a3 = new Author(202, "Liviu Rebreanu");

        var b1 = new Book(1000, "Amintiri din Java");
        a1.addAuthoredBook(b1);

        var b2 = new Book(1001, "Moara cu noroc");
        a1.addAuthoredBook(b2);

        var b3 = new Book(1002, "Padurea Spanzuratilor");
        a3.addAuthoredBook(b3);


        TextFileBookRepository repo = new TextFileBookRepository("books.txt");
//        for (var o : repo.getAll()) {
//            System.out.println(o);
//        }

//        repo.store(b1);
//        repo.store(b2);
//        repo.store(b3);

        AuthorTextFileRepository authorRepo = new AuthorTextFileRepository("authors.txt", repo);
        for (var a : authorRepo.getAll()) {
            System.out.println(a);
            System.out.println("\t" + ((Author) a).getBooks());
        }


//        authorRepo.store(a1);
//        authorRepo.store(a2);
//        authorRepo.store(a3);


//        BookService service = new BookService(repo);
//        UI ui = new UI(service);
//        ui.startUI();
    }

}
