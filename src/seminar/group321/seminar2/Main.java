package seminar.group321.seminar2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        try {
            Author banks = new Author(1000, "Iain Banks");
            Book book_1 = new Book(2000, banks, "My first book");
            Book book_2 = new Book(2001, banks, "Player of Games");
            Book book_3 = new Book(2001, banks, "Player of Games");

//            Repository<Book> myRepo = new Repository<>();
//            myRepo.add(book_1);
//            myRepo.add(book_2);
//            myRepo.add(book_3);
//            myRepo.add(book_2);
//            System.out.println(myRepo);

            Repository<Author> authorRepo = new Repository<>();
            authorRepo.add(banks);
            authorRepo.add(new Author(1001, "Mihai Eminescu"));
            authorRepo.add(new Author(1002, "Ion Creanga"));

            // Modul de iterare "traditional" peste o colectie Java
//            while (authorIterator.hasNext()) {
//                System.out.println(authorIterator.next());
//            }

            // enhanced for loop
            for (Author author : authorRepo) {
                System.out.println(author);
            }

            AuthorService as = new AuthorService(authorRepo);
//            ConsoleUI consoleUI = new ConsoleUI(as);

//            System.out.println(as.getAllAuthors());


        } catch (DuplicateIDException exc) {
            System.out.println("Duplicate id exception detected!");
        } catch (BookstoreException exc2) {
            System.out.println("Another bookstore exception!");
        }
    }
}
