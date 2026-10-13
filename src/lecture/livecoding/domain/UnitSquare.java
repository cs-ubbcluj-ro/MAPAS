package lecture.livecoding.domain;

public class UnitSquare extends Square {

    private static UnitSquare instance;

    // Constructorul private nu permite apelarea din afara clasei
    private UnitSquare() {
        super(1, "The unit square", 1);
    }

    @Override
    public String toString() {
        return "UnitSquare{} " + super.toString();
    }

    // Metoda imi da acces la instanta unica de UnitSquare
    public static UnitSquare getInstance() {
        if (instance == null) {
            instance = new UnitSquare();
        }

        // C++
        // UnitSquare us; // alocat pe stiva, se face copie
        // UnitSquare* us = new UnitSquare us(); // alocat pe heap, nu e nevoie de copie

        return instance;
    }
}
