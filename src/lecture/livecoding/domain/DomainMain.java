package lecture.livecoding.domain;

public class DomainMain {
    public static void main(String[] args) {

        Shape myShape = new Shape(1000);
        Shape yourShape = new Shape(1001, "new Shape");
        System.out.println(myShape);
        System.out.println(yourShape);
    }
}
