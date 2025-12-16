package lecture.livecoding;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Lecture_11 {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, RepositoryException {

        // sq este un obiect al clasei lecture.livecoding.Square
        Rectangle rectangle = new Rectangle(100, 6, 5);

        // squareClass este un obiect al clasei java.lang.Class, care reprezinta in masina virtuala
        // clasa Square
        Class currentClass = rectangle.getClass();
        System.out.println(currentClass.getName());

        for (var field : currentClass.getDeclaredFields()) {
            System.out.println("\t field - " + field.getType() + " : " + field.getName());
        }

        for (var method : currentClass.getDeclaredMethods()) {
            System.out.println("\t method - " + method.getReturnType() + " : " + method.getName());
        }

        do {
            currentClass = currentClass.getSuperclass();
            System.out.println(currentClass.getName());

            for (var field : currentClass.getDeclaredFields()) {
                System.out.println("\t field - " + field.getType() + " : " + field.getName());
            }


            for (var method : currentClass.getDeclaredMethods()) {
                System.out.println("\t method - " + method.getReturnType() + " : " + method.getName());
            }

        } while (currentClass != Object.class);


        Class squareClass = Class.forName("lecture.livecoding.Square");
        Constructor squareConstructor = squareClass.getConstructor(int.class, String.class, int.class);
        Shape square = (Shape) squareConstructor.newInstance(100, "My Square", 7);

        System.out.println(square.getId() + " " + square.getArea());


        IRepository repo = Settings.getInstance().getRepository();
        System.out.println(repo.getClass().getName());
        repo.store(new Square(101, "another square", 44));

        for (var elem : repo) {
            System.out.println(elem);
        }


        repo.close();

//        System.out.println(rectangleClass.getName());
//        Field widthField = rectangleClass.getField("width");
//        for (var field : rectangleClass.getFields()) {
//            System.out.println(field.getType().getName() + " : " + field.getName());
//        }


    }

}
