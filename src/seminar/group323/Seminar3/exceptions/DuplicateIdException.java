package seminar.group323.Seminar3.exceptions;

public class DuplicateIdException extends RepositoryException {
    public DuplicateIdException(int id) {
        super("Exista deja un obiect cu ID=" + id);
    }
}