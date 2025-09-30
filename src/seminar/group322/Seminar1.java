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

public class Seminar1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(args.length);

        // enhanced for loop
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
