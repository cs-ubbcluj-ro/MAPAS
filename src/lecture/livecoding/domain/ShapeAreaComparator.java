package lecture.livecoding.domain;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Shape == false) {
            // o1 e obiect de tipul Shape sau orice subclasa a lui Shape?
            throw new IllegalArgumentException();
        }

        if (o2 instanceof Shape == false) {
            // o1 e obiect de tipul Shape sau orice subclasa a lui Shape?
            throw new IllegalArgumentException();
        }

        Shape s1 = (Shape) o1;
        Shape s2 = (Shape) o2;


        return (int) (s1.getArea() - s2.getArea());
    }
}
