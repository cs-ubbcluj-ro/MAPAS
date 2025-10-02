package lecture.livecoding;

import java.util.ArrayList;
import java.util.List;

public class Lecture {

    private static boolean isPrime(int n) {
        // int - este un tip primitiv de data (nu e clasa)
        // Integer - este o clasa
        // mecanismul de conversie automat Integer/int se numeste Java autoboxing
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> listaNumere = new ArrayList<>();

        for (String argument : args) {
            try {
                int n = Integer.valueOf(argument);
                if (Lecture.isPrime(n)) {
                    listaNumere.add(n);
                }
            } catch (NumberFormatException e) {
                System.out.println("Parametru care nu e numar intreg: " + argument);
            }
        }

        System.out.println("Numerele intregi din linia de comanda");
        for (Integer n : listaNumere) {
            System.out.println(n);
        }
    }
}
