package seminar.repository;

import seminar.domain.Book;

import java.util.ArrayList;
import java.util.Collection;

public class BookRepository {

    private final ArrayList<Book> data;

    public BookRepository() {
        data = new ArrayList<>();
    }

    public void addBook(Book book) {
        data.add(book);
    }

    /*
    Clasa Collection este supra-clasa a lui ArrayList
     */
    public Collection<Book> getAll() {
        return data;
    }
}
