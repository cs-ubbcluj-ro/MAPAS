package seminar.domain;

import java.util.Objects;

public class Book extends LibraryObject {

    /*
    Generarea codului sursa folosind IDE-ul

    1. Scrieti campurile id, author, name
    2. Generate...
        -> constructor
        -> equals and hashCode
        -> toString
        -> Getters
     */

    protected Author author;
    protected String title;

    public Book(int id, String title) {
        super(id);
        this.title = title;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return getId() == book.getId() && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + Objects.hashCode(author);
        result = 31 * result + Objects.hashCode(title);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +

                ", title='" + title + '\'' +
                '}';
    }
}
