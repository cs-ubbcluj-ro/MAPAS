package lecture.livecoding;

import lecture.livecoding.domain.*;

import java.util.ArrayList;

public class Lecture3 {
    public static void main(String[] args) {

        System.out.println("Shape objects - " + Shape.getNumberOfObjects());

        Shape s = new Rectangle(1000, "First shape", 3, 2);

        // toString
        System.out.println(s); // toString - Java sau __str__ - Python 3

        // ==
        Shape s2 = new Rectangle(1000, "First shape", 4, 3);
        System.out.println(s == s2); // s si s2 sunt stocate la adrese diferite pe heap

        // equals
        System.out.println(s.equals(s2)); // __eq__ in Python 3
        // In Python, __eq__ se apeleaza la ==
        // In Java, equals se apeleaza doar la o.equals(...)
        // NB Java nu permite suprascierea operatorilor

        Shape squareOne = new Square(1002, "Square One", 4);
        System.out.println(squareOne.getArea());

        System.out.println("Shape objects - " + Shape.getNumberOfObjects());

        UnitSquare us1 = UnitSquare.getInstance();
        UnitSquare us2 = UnitSquare.getInstance();
        System.out.println(us1 == us2); // trebuie sa returneze true
        System.out.println("Shape objects - " + Shape.getNumberOfObjects());

        ArrayList shapes = new ArrayList();
        shapes.add(squareOne);
        shapes.add(us1);
        shapes.add(us2);
        shapes.add(s2);

        shapes.sort(new ShapeAreaComparator());
        for (Object shapeObject : shapes) {
            System.out.println(shapeObject);
        }

    }
}
