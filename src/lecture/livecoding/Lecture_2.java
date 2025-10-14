package lecture.livecoding;

public class Lecture_2 {
    public static void main(String[] args) {
        System.out.println("Hello");

        /*
        La un moment dat clasa Shape a devenit abstracta => codul de mai jos
        nu mai poate rula
         */


        // In cazul in care o clasa nu are definit un constructor in mod explicit,
        // compilatorul Java genereaza un constructor fara parametri
//         Shape shape_1 = new Shape();


//        Shape shape_1 = new Shape(100);
//        Shape shape_2 = new Shape(100, "O forma");
//        Shape shape_3 = shape_1;

//        System.out.println(shape_1 == shape_2);
//        System.out.println(shape_1 == shape_3);

        // Grija ca shape_1 sa nu fie null !
//        System.out.println(shape_1.equals(shape_2));
//        System.out.println(shape_1.equals(shape_3));

        // In Java, toate metodele (cu exceptia constructorului) sunt polimorfice
//        Object o1 = new Shape(200, "Shape 1");
//        Object o2 = new Shape(200, "Shape 1");
//        System.out.println(o1.equals(o2));

        Shape s = new Rectangle(200, "Dreptungi 1,", 3, 2);
        System.out.println("Numar de instante Shape=" + Shape.instanceCount());
    }
}
