package seminar.domain;

import java.util.Objects;

public class Book {

    /*
    Generarea codului sursa folosind IDE-ul

    1. Scrieti campurile id, author, name
    2. Generate...
        -> constructor
        -> equals and hashCode
        -> toString
        -> Getters
     */

    protected int id;
    protected String author;
    protected String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
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
        return id == book.id && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(author);
        result = 31 * result + Objects.hashCode(title);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
