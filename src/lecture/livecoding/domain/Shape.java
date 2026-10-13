package lecture.livecoding.domain;

import java.util.Objects;

public abstract class Shape {

    private static int numberOfObjects = 0;

    private int id;

    private String name;

    public Shape(int id) {
        this.id = id;
        Shape.numberOfObjects += 1;
    }

    public Shape(int id, String name) {
        // Putem apela un constructor din alt constructor
        // this() trebuie sa fie prima instructiune
        this(id);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();
    //C++
    // public: virtual double getArea() = 0;


    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;
        return id == shape.id && Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
