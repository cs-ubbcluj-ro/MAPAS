package seminar.group321.seminar2;

import java.util.Collection;

public class AuthorService {
    /*
    1. In general, fiecare entitate a problemei ar trebui sa aiba propria clasa Service
    2. De regula, operatiile depind de entitate => clasa service nu e generica
     */

    private Repository<Author> authorRepo;


    public AuthorService(Repository<Author> authorRepo) {
        this.authorRepo = authorRepo;

    }

    public void addAuthor(Author author) throws DuplicateIDException {
        this.authorRepo.add(author);
    }

    public Collection<Author> getAllAuthors() {
        return this.authorRepo.getAll();
    }
}
