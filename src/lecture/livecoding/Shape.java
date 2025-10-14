package lecture.livecoding;

import java.util.Objects;

public abstract class Shape {

    // Toate obiectele de tip Shape (si subclasele lor) au acces la aceeasi
    // variabila instance_count
    private static int instanceCount = 0;


    /**
     * Modificatori pentru protectia la accesarea campurilor
     * <p>
     * private/protected/public
     * implicit (nu scriem nimic) - "package private" (accesibil in cadrul pachetului)
     */
    private int id;

    // name e de tip String => valoarea implicita este null
    private String name;

    /**
     * Polimorfism static = avem mai multe metode cu acelasi nume, dar care difera
     * prin lista parametrilor formali => compilatorul poate decide care varianta
     * trebuie apelata
     */

    public Shape(int id) {
        // Definirea constructorului cu parametri ne ajuta sa stabilim care campuri sunt
        // obligatorii la crearea unui obiect

        // Contructorii nu returneaza nimic in mod explicit
        // JVM (Java Virtual Machine) returneaza referinta spre noul obiect
        this.id = id;
        Shape.instanceCount += 1;
    }

    public Shape(int id, String name) {
        /**
         * Un constructor poate apela un altul
         * Acest apel, daca exista, trebuie sa fie primul din metoda
         */
        this(id);
        this.name = name;
    }

    public int getId() {
        /**
         * Un atribut al unei clase pentru care am definit un getter (dar nu si un
         * setter) este "read-only" - valoarea setata in constructor nu poate fi
         * modificata
         */
        return id;
    }

    /**
     * Avem o metoda pe care nu stim sau nu putem sa o implementam cu informatiile
     * avute => metoda va fi implementate de clasele derivate.
     */
    public abstract float getArea();


    public static int instanceCount() {
        // Shape.instanceCount si System.out sunt membri static ai
        // claselor Shape respectiv System
        return Shape.instanceCount;
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
}
