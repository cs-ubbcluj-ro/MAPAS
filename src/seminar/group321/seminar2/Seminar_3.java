package seminar.group321.seminar2;


public class Seminar_3 {
    public static void main(String[] args) throws BookstoreException {


//        Repository<Author> authorRepo = new AuthorTextFileRepository("authors.txt");

        Repository<Author> authorRepo = new BinaryFileRepository<>("authors.bin");
//        authorRepo.add(new Author(1001, "Mihai Eminescu"));
//        authorRepo.add(new Author(1002, "Ion Creanga"));
//        authorRepo.add(new Author(1003, "Ioan Slavici"));

        for (var author : authorRepo) {
            System.out.println(author);
        }
    }
}
