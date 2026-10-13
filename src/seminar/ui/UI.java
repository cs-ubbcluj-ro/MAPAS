package seminar.ui;

import seminar.domain.Book;
import seminar.domain.BookComparatorByAuthor;
import seminar.domain.BookComparatorByTitle;
import seminar.service.BookService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UI {
    private BookService service;

    public UI(BookService service) {
        this.service = service;
    }

    public void startUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the library!");
        boolean flag = true;

        while (flag) {
            System.out.println("1. Display all books (sort by author)");
            System.out.println("2. Display all books (sort by title)");
            System.out.println("0. Exit");

            String option = input.nextLine();
            if ("1".equals(option)) {
                displayAllBook(new BookComparatorByAuthor());
            } else if ("2".equals(option)) {
                displayAllBook(new BookComparatorByTitle());
            } else if ("0".equals(option)) {
                flag = false;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    private void displayAllBook(Comparator<Book> comparator) {
        // Initializam lista cu toate cartile din repository
        ArrayList<Book> bookList = new ArrayList<>(service.getAll());
        bookList.sort(comparator);

        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
