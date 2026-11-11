package seminar.repository;

import seminar.domain.Book;
import seminar.domain.LibraryObject;

import java.util.ArrayList;
import java.util.Collection;

public class LibraryObjectRepository {

    protected final ArrayList<LibraryObject> data;

    public LibraryObjectRepository() {
        data = new ArrayList<>();
    }

    public void store(LibraryObject book) throws RepositoryException {
        if (find(book.getId()) != null) {
            throw new RepositoryException("Duplicate ID", null);
        }

        data.add(book);

    }

    public LibraryObject find(int id) {
        for (var b : data) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }

    /*
    Clasa Collection este supra-clasa a lui ArrayList
     */
    public Collection<LibraryObject> getAll() {
        return new ArrayList<>(data);
    }
}
