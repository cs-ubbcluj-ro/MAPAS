package seminar.group323.Seminar4.exceptions;

import seminar.group323.Seminar4.exceptions.RepositoryException;

public class ObjectNotFoundException extends RepositoryException {
    public ObjectNotFoundException(int id) {
        super("Nu exista obiect cu ID=" + id);
    }
}
