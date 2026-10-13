package lecture.livecoding.domain;

public class Square extends Rectangle {
    public Square(int id, String name, int side) {
        super(id, name, side, side);
    }

    @Override
    public String toString() {
        return "Square{} " + super.toString();
    }
}
