package lecture.livecoding;

public class Lecture_5 {
    public static void main(String[] args) throws RepositoryException {
        IRepository<Shape> repo = new BinaryFileRepository<>("shapes.bin");
        repo.store(new Rectangle(1000, "rec1", 3, 2));
        repo.store(UnitSquare.getInstance());

        for (Shape s : repo) {
            System.out.println(s);
        }


    }
}
