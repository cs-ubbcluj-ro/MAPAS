package lecture.livecoding;

public class Lecture_6 {
//    IRepository<Rectangle> repo = new TextFileRepository<>("rectangles.txt", new RectangleConverter());

    public static void main(String[] args) throws RepositoryException {
        IRepository<Rectangle> repo = new TextFileRepository<>("rectangles.txt", new RectangleConverter());
        repo.store(new Rectangle(1000, "R1", 3, 2));
        repo.store(new Rectangle(1001, "R2", 30, 2));

//        for (var r : repo) {
//            System.out.println(r);
//        }

        IRepository<Square> sqlRepo = new SQLSquareRepository();
        sqlRepo.store(UnitSquare.getInstance());
        sqlRepo.store(new Square(101, "square two", 5));

        for (var s : sqlRepo) {
            System.out.println(s);
        }
    }
}
