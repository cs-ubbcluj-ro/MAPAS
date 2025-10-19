package lecture.livecoding;

import org.w3c.dom.ls.LSOutput;

public class Main {


    public static void main(String[] args) {
        Shape square_1 = UnitSquare.getInstance();
        Shape square_2 = UnitSquare.getInstance();
        Shape square_3 = new Square(1000, "Unit Square", 1);

//        System.out.println(square_3.equals(square_1));
//        System.out.println(square_1.equals(square_3));

//        System.out.println(square_1 == square_2);
//        System.out.println(square_1 == square_3);
//        System.out.println(square_1.equals(square_3));

        Shape rect_1 = new Rectangle(1, "dreptunghi", 3, 2);

        // getClass() - returneaza clasa exact a obiectului
//        System.out.println(square_1.getClass());
//        System.out.println(rect_1.getClass() == square_1.getClass());

        //
//        System.out.println(square_1 instanceof Square);
//        System.out.println(square_1 instanceof Rectangle);
//        System.out.println(square_1 instanceof Shape);
//        System.out.println(square_1 instanceof Object);

        // Asa instantiem o clasa inner (non-statica si non-private)
//        SimpleLinkedList list = new SimpleLinkedList();
//        SimpleLinkedList.Node node = list.new Node();

        IList<Square> list = new SimpleLinkedList<Square>();
        

        list.add(UnitSquare.getInstance());
//        list.add((Square) rect_1);
        list.add((Square) square_3);
        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }

}
