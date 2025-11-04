package seminar.group323.Seminar3.exceptions;

public class ObjectNotFoundException extends RepositoryException {
    public ObjectNotFoundException(int id) {
        super("Nu exista obiect cu ID=" + id);
    }
}
