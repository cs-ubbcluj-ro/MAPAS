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

    private static List<Integer> longestOddSequence(List<Integer> numbers) {
        int maxStart = -1;
        int maxEnd = -1;

        int currentStart = 0;
        int currentEnd = 0;

        int index = 0;
        while (index < numbers.size()) {
            if (numbers.get(index) % 2 == 0) {
                currentStart = index + 1;
            } else {
                currentEnd = index + 1;
                if (currentEnd - currentStart > maxEnd - maxStart) {
                    maxStart = currentStart;
                    maxEnd = currentEnd;
                }
            }
            index += 1;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = maxStart; i < maxEnd; i++) {
            result.add(numbers.get(i));
        }
//        System.out.println(maxStart);
//        System.out.println(maxEnd);
        return result;
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
                    continue; // trece la urmatoarea iteratie a celei mai apropiate bucle
                    // innermost loop
                case "2":
                    continue;
                case "3":
                    continue;
                case "4":
                    List<Integer> result = longestOddSequence(numbers);
                    for (Integer num : result) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    continue;
                case "5":
                    System.out.println("Lista de numere:");
                    for (Integer num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    continue;
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
