package lecture.livecoding;

import java.util.Objects;

public class Square extends Rectangle {
    public Square(int id, String name, int side) {
        super(id, name, side, side);
    }


    /**
     * In cazul că exista setWidth(), setHeight(), avem grija ca la Square
     * acestea sa aiba aceeasi valoare
     */

    @Override
    public boolean equals(Object o) {
        // instanceof ne permite sa spunem ca un obiect de tip patrat poate fi
        // logic egal cu un alt obiect, al unei clase derivate din Square
        // (ex UnitSquare)
        if (!(o instanceof Square)) return false;

        Square shape = (Square) o;
        return getId() == shape.getId() && Objects.equals(getName(), shape.getName());
    }

    @Override
    public String toString() {
        return getId() + " name: " + getName() + " side: " + getWidth();
    }
}
