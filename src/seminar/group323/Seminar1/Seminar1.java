package seminar.group323.Seminar1;
/*
    Se lucreaza cu o lista de numere. Aceste numere se pot citi in doua moduri:
        - din linia de comanda
        - daca nu exista argumente in linia de comanda, de la tastatura
    In orice mod ar fi citita lista, este necesara gestionarea cazului in care se citeste si altceva decat un numar.

    Scrieti o aplicatie cu un meniu care are urmatoarele functionalitati:
        1. Afisati minimul din lista de numere.
        2. Eliminati numerele prime din lista.
        0. Iesire
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seminar1 {
    private static void printMenu() {
        System.out.println("1. Afisati minimul din lista de numere");
        System.out.println("2. Eliminati numerele prime");
        System.out.println("0.Iesire");
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void eliminaPrime(List<Integer> numere) {
        for (int i = 0; i < numere.size(); i++) {
            if (isPrime(numere.get(i))) {
                numere.remove(i);
                i--;
            }
        }
    }

    private static void runMenu(List<Integer> numere) {

        Scanner sc = new Scanner(System.in);

//        try{
//
//        }
//        catch (Exception e){}
        while (true) {
            printMenu();
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    if (numere.isEmpty()) {
                        System.out.println("Lista este goala.");
                    } else {
                        int minim = numere.get(0); // TODO Arthur - aici era eroare de compilare
                        for (int x : numere) {
                            if (x < minim) minim = x;
                        }
                        System.out.println("Minimul din lista este: " + minim);
                    }
                    break;

                case "2":
                    eliminaPrime(numere);
                    System.out.println("Lista dupa eliminarea numerelor prime: " + numere);
                    break;

                case "0":
                    System.out.println("Program terminat.");
                    return;

                default:
                    System.out.println("Optiune inexistenta.");
            }
        }
    }

    private static List<Integer> parseArguments(String[] args) {
        List<Integer> numere = new ArrayList<>();
        for (String arg : args) {
            try {
                numere.add(Integer.parseInt(arg));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return numere;
    }

    public static void main(String[] args) {
        System.out.println("Seminar 1");
//        System.out.println(args[0]);
        Scanner sc = new Scanner(System.in);
        // exemplu citire numar intreg:
//        Integer line = sc.nextInt();
//        System.out.println(line);

        List<Integer> list;

        if (args.length > 0) {
            System.out.println("Citire numere din linia de comanda: ");
            list = parseArguments(args);
        } else {
            System.out.println("Introduceti numerele separate prin spatiu: ");
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");

            list = parseArguments(inputArray);
        }

        System.out.println("Lista initiala: " + list);

        runMenu(list);
    }
}
