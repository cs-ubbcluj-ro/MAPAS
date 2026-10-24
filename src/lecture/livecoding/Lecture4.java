package lecture.livecoding;

import lecture.livecoding.domain.Rectangle;
import lecture.livecoding.domain.Square;
import lecture.livecoding.domain.UnitSquare;
import lecture.livecoding.repository.IRepository;
import lecture.livecoding.repository.MemoryRepository;
import lecture.livecoding.repository.RepositoryException;
import lecture.livecoding.util.ILinkedList;
import lecture.livecoding.util.SimpleLinkedList;

import java.util.Iterator;

public class Lecture4 {
    public static void main(String[] args) {

        SimpleLinkedList simpleList = new SimpleLinkedList();

        // Putem crea un obiect al clasei inner (cat timp e public)
//        SimpleLinkedList.Node node = simpleList.new Node(null, null);

        ILinkedList anonymousList = new ILinkedList() {

            @Override
            public void add(Object element) {

            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        System.out.println(anonymousList.size());

        // Similar cu functia type() din Python 3
        System.out.println(anonymousList.getClass().getName());

        SimpleLinkedList<Square> squaresList = new SimpleLinkedList<>();
//        squaresList.add(new Rectangle(1, "Bla", 3, 2));
        squaresList.add(new Square(2, "SQ1", 3));
        squaresList.add(UnitSquare.getInstance());
        squaresList.add(UnitSquare.getInstance());
        squaresList.add(UnitSquare.getInstance());
        squaresList.add(UnitSquare.getInstance());

        System.out.println(squaresList.size());


        IRepository<Rectangle> memoryRepo = new MemoryRepository<>();
        try {
            memoryRepo.store(new Rectangle(101, "Bla", 3, 2));
            memoryRepo.store(new Square(2, "SQ1", 3));
            memoryRepo.store(UnitSquare.getInstance());
            memoryRepo.store(UnitSquare.getInstance());
//            memoryRepo.store(UnitSquare.getInstance());
//            memoryRepo.store(UnitSquare.getInstance());
        } catch (
                Exception e) {
            System.out.println("Error: " + e.toString());
        }

        System.out.println(memoryRepo.size());
        System.out.println(memoryRepo.findById(1));

        // Iterator clasic in Java
        Iterator<Rectangle> repoIterator = memoryRepo.iterator();
        while (repoIterator.hasNext()) {
            System.out.println(repoIterator.next());
        }

        // Enhanced for loop
        for (Rectangle r : memoryRepo) {
            System.out.println(r);
        }

    }
}
