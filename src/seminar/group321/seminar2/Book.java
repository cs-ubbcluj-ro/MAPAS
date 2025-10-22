package seminar.group321.seminar2;

import java.util.Objects;

public class Book extends IdObject {

    // FIXME Carti cu mai multi autori !?
    private Author author;

    private String title;

    public Book(int id, Author author, String title) throws BookstoreException {
        super(id);

        if (author == null || title == null || title.isEmpty()) {
            // BookstoreException este un "checked exception", adica trebuie declarat ca metoda poate sa arunce
            // aceasta exceptie
            throw new BookstoreException("Autor sau titlu nule");

            // IllegalArgumentException este un RuntimeException (unchecked exception) => nu trebuie declarat faptul
            // ca poate fi aruncat de codul nostru
//            throw new IllegalArgumentException("Autor sau titlu nule");

            /*
            checked exception - situatii care se pot intalni in cadrul executiei "normale" a programului (ex: se doreste
            citirea unui fiser inexsitent, conexiune invalida spre DB, nu sunt drepturi pentru a face ceva

            unchecked exception - in general, buguri care ar trebui reparate in procesul de dezvoltare.
             */

        }
        // FIXME Exceptie in cazul unei carti fara autor sau fara titlu
        this.author = author;
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
        int result = Objects.hashCode(author);
        result = 31 * result + Objects.hashCode(title);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", id=" + id +
                "} " + super.toString();
    }
}
