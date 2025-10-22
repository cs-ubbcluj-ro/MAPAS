package seminar.group321.seminar1;

import java.util.Objects;

public class Book {
    private String author;
    private String title; // java.lang.String este o clasa
    private int year; // int este un tip primitiv (ca si int in C/C++)

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return year == book.year && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(author);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
