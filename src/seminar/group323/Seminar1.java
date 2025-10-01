package seminar.group323;
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
import java.util.List;
import java.util.Scanner;

public class Seminar1 {
    private static void printMenu() {
        System.out.println("1. Afisati minimul din lista de numere");
        System.out.println("2. Eliminati numerele prime");
        System.out.println("0.Iesire");
    }

    private static void runMenu() {
        printMenu();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
//        try{
//
//        }
//        catch (Exception e){}
        while (true) {
            switch (line) {
                case "1":
                    //functie 1

                case "2":
                    //functtie 2
                case "0":
                    return;
                default:
                    System.out.println("optiune inexistenta");

            }
        }
    }
    private static List<Integer> parseArguments(String[] args){
      List <Integer> numere = new ArrayList<Integer>();
      for (String arg: args){
          try{
          numere.add(Integer.parseInt(arg));}
          catch (Exception e){}
      }
      return numere;
    }

    public static void main(String[] args) {
        System.out.println("Seminar 1");
//        System.out.println(args[0]);
        Scanner sc = new Scanner(System.in);
        Integer line = sc.nextInt();
//        String argumente = sc. nextLine();
        System.out.println(line);
        System.out.println("Introduceti numerele separate prin spatiu: ");
        String input = sc.nextLine();
        String [] inputArray = input.split(" ");
       List<Integer> list =  parseArguments(inputArray);
        runMenu();
    }
}
