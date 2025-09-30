package seminar.group322;

/*
    Se lucreaza cu o lista de numere. Aceste numere se pot citi in doua moduri:
        - din linia de comanda
        - daca nu exista argumente in linia de comanda, de la tastatura
    In orice mod ar fi citita lista, este necesara gestionarea cazului in care se citeste si altceva decat un numar.

    Scrieti o aplicatie cu un meniu care are urmatoarele functionalitati:
        1. Afisati minimul din lista de numere.
        2. Eliminati numerele prime din lista.
        3. Cautare numar dat de la tastatura
        3. Gasiti cea mai lunga secventa de numere impare din lista.
        4. Iesire
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Seminar1 {
    private static List<Integer> parseArguments(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>(); // lista stocata pe un vector
//        List<Integer> numbers2 = new LinkedList<>();  // lista dublu inlantuita

        for (String arg : args) {
            try {
                numbers.add(Integer.parseInt(arg));
            } catch (NumberFormatException e) {

            }
        }

        return numbers;
    }

    private static void printMenu() {
        System.out.println("1. Afisati minimul din lista de numere");
        System.out.println("2. Eliminati numerele prime din lista");
        System.out.println("3. Cautare numar dat de la tastatura");
        System.out.println("4. Gasiti cea mai lunga secventa de numere impare din lista");
        System.out.println("5. Afiseaza toate numerele din lista");
        System.out.println("0. Iesire");
    }

    private static void startUI(List<Integer> numbers) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String line = scanner.nextLine();

            switch (line) {
                case "1":
                    continue;
                case "2":
                    continue;
                case "3":
                    continue;
                case "4":
                    continue;
                case "5":
                    System.out.println("Lista de numere:");
                    for (Integer num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                case "0":
                    return;
                default:
                    System.out.println("Optiunea nu exista!");
            }

        }
    }


    public static void main(String[] args) {

//        int x = 7;
//        List<Integer> numbers = new LinkedList<>();
//        numbers.add(x);

        if (args.length == 0) {
            System.out.println("Introduceti numerele separate prin spatiu: ");
            Scanner sc = new Scanner(System.in);
            String inputLine = sc.nextLine();
            String[] inputArray = inputLine.split(" ");
            args = inputArray;
        }

        startUI(parseArguments(args));
//        for (Integer arg : numbers) {
//            System.out.println(arg);
//        }
    }
}
