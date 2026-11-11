package seminar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author extends LibraryObject {

    protected String name;
    protected List<Book> books = new ArrayList<>();

    public Author(int id, String name) {
        super(id);
        this.name = name;
    }

    public void addAuthoredBook(Book b) {
        // FIXME De verificat ca nu apar duplicate
        this.books.add(b);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
