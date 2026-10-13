package seminar;

import seminar.domain.Book;
import seminar.repository.BookRepository;
import seminar.service.BookService;
import seminar.ui.UI;

public class LibraryMain {
    public static void main(String[] args) {
        BookRepository repo = new BookRepository();
        repo.addBook(new Book(1000, "Ion Creangă", "Amintiri din Java"));
        repo.addBook(new Book(1001, "Ioan Slavici", "Moara cu noroc"));
        repo.addBook(new Book(1002, "Liviu Rebreanu", "Padurea Spanzuratilor"));

        BookService service = new BookService(repo);
        UI ui = new UI(service);
        ui.startUI();
    }

}
