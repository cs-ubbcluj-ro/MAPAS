package lecture.livecoding;


import java.util.ArrayList;

public class Lecture2 {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }

        System.out.println("We have " + args.length + " command line params");

        // Toate tipurile colectie sunt parametrizate implicit
        // ArrayList seamana cu stl::vector, sau list din Python 3
        ArrayList<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            // Integer -- tipul de data intreg, ca si clasa in Java
            try {
                int intValue = Integer.parseInt(args[i]);
                if (isPrime(intValue)) {
                    numbersList.add(intValue);
                }
            } catch (NumberFormatException e) {
                System.out.println("not an integer - " + args[i]);
            }
        }

        // "Enhanced for loop" - e itereaza peste toate elementele lui numbersList
        System.out.println("Primes in list");
        for (int e : numbersList) {
            System.out.println(e);
        }

    }
}
