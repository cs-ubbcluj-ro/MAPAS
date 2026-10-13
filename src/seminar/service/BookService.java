package seminar.service;

import seminar.domain.Book;
import seminar.repository.BookRepository;

import java.util.Collection;

public class BookService {

    // atribut final => nu i se poate modifica valoarea dupa prima atribuire (e o constanta Java)
    // metoda final => nu se poate suprascrie
    // clasa final => nu se paote mosteni
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        /*
        Este important ca repository-ul sa fie transmis ca parametru al constructorului
        De ce?
            1. Putem schimba repository-ul folosit fara sa modificam clasa Server
            2. Putem porni mai multe instante Service cu repository-uri diferite
         */
        this.repository = repository;
    }

    public void addBook(Book book) {
        this.repository.addBook(book);
    }

    public Collection<Book> getAll() {
        return this.repository.getAll();
    }
}
