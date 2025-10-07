package seminar.group321.seminar1;

import seminar.Book;
import seminar.group322.Seminar1;

import java.util.ArrayList;
import java.util.Scanner;

public class Seminar_1 {

    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void addBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("Author: ");
        String author = in.nextLine();

        System.out.println("Title: ");
        String title = in.nextLine();

        System.out.println("Year: ");
        // TODO Wrap in a try { } catch (NumberFormatException e) block
        int year = Integer.parseInt(in.nextLine());

        bookList.add(new Book(author, title, year));
    }

    public static void mainMenu() {
        boolean keepRunning = true;
        Scanner in = new Scanner(System.in);


        do {
            System.out.println("1. Display all books");
            System.out.println("2. Add a book");
            System.out.println("0. Exit");
            String userOption = in.nextLine();

            switch (userOption) {
                case "1":
                    System.out.println("All books:");
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                    break;
                case "2":
                    addBook();
                    break;
                case "0":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        } while (keepRunning);
    }

    public static ArrayList<Book> processCommandLine(String[] args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg);
            result.append(" ");
        }

        ArrayList<Book> bookList = new ArrayList<>();
        String[] tokens = result.toString().split(",");
        // TODO Verificat ca nr. de tokens este multiplu de 3
        for (int i = 0; i < tokens.length; i += 3) {
            // TODO Prindem exceptia aruncata daca anul nu este un numar intreg in baza 10
            bookList.add(new Book(tokens[i], tokens[i + 1], Integer.parseInt(tokens[i + 2].trim())));
        }
        return bookList;
    }


    public static void main(String[] args) {
        System.out.println("Hello group 321!");
        bookList = Seminar_1.processCommandLine(args);
        mainMenu();

//        ArrayList<Book> bookList = new ArrayList<>();


//        for (String arg : args) {
//            System.out.println(arg);
//        }
    }
}
