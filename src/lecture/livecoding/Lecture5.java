package lecture.livecoding;

import lecture.livecoding.domain.Square;
import lecture.livecoding.domain.UnitSquare;
import lecture.livecoding.repository.BinaryFileRepository;
import lecture.livecoding.repository.RepositoryException;

import java.io.*;

class Student implements Serializable {
    private String name;
    private int age;
    private transient int grade;
    private int mean;

    private static final long serialVersionUID = 0;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getMean() {
        return mean;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}

public class Lecture5 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, RepositoryException {

        Student s = new Student("Popescu Mara", 20, 9);

//        ObjectOutputStream oos = null;
//        try {
//            oos = new ObjectOutputStream(new FileOutputStream("student.data"));
//            oos.writeObject(s);
////            oos.close();
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        } finally {
//            try {
//                oos.close();
//            } catch (IOException e) {
//                System.out.println(e.toString());
//            }
//        }

        //try-with-resources
//        try {
//            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.data"));) {
//                oos.writeObject(s);
//            }
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }


//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.data"));
//         s = (Student) ois.readObject();
//
//        System.out.println(s);


        BinaryFileRepository<Square> bfRepo = new BinaryFileRepository<>("squares.data");
//        bfRepo.store(new Square(102, "one two", 3));
//        bfRepo.store(new Square(101, "one", 2));

        for (Square sq : bfRepo) {
            System.out.println(sq);
        }


    }
}
