package seminar.group323.Seminar4.exceptions;

import seminar.group323.Seminar4.exceptions.RepositoryException;

public class DuplicateIdException extends RepositoryException {
    public DuplicateIdException(int id) {
        super("Exista deja un obiect cu ID=" + id);
    }
}